package com.signia.backend.controller;

import com.signia.backend.model.Authorization;
import com.signia.backend.model.Message;
import com.signia.backend.model.Opt;
import com.signia.backend.service.impl.AuthorizationServiceImpl;
import com.signia.backend.service.impl.OptServiceImpl;
import com.signia.backend.util.impl.CheckDataServiceImpl;
import com.signia.backend.util.impl.RandomCodeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Optional;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/")
public class ControllerUser {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AuthorizationServiceImpl authorizationService;

    @Autowired
    private OptServiceImpl optService;

    @Autowired
    private RandomCodeServiceImpl randomCodeService;

    @Autowired
    private CheckDataServiceImpl checkDataService;


    @PostMapping("/login")
    public ResponseEntity<Object> authenticateUser(@RequestBody final Authorization user) {
        Optional<Authorization> aut = authorizationService.getUserAuth(user);

        if (aut.isEmpty()) {
            String message = "This email is not associated with a user account, or password is incorrect. Are you sure you've registered?";
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        } else {
            Message message = new Message("550e8400-e29b-41d4-a716-446655440000" , randomCodeService.generateRandomCode(4));
            Opt opt = new Opt();
            opt.setCode(message.getCode());
            opt.setSessionId(message.getSessionId());
            opt.setDateCreateOpt((ZonedDateTime.now()));
            opt.setIdAuthorization(aut.get().getId());
            optService.setOpt(opt);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
    }

    @PostMapping("/opt")
    public ResponseEntity<Object> optParam(@RequestBody final Opt opt) {
        Optional<Opt> findOpt = optService.getOpt(opt.getCode());
        if (findOpt.isEmpty()) {
            return new ResponseEntity<>("Error", HttpStatus.OK);
        } else if (checkDataService.checkDate(findOpt.get().getDateCreateOpt())) {
            return new ResponseEntity<>("Susses", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Unknown error occured", HttpStatus.OK);
        }
    }
}
