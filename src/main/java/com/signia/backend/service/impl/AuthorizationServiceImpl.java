package com.signia.backend.service.impl;

import com.signia.backend.model.Authorization;
import com.signia.backend.repository.AuthorizationRepository;
import com.signia.backend.service.AuthorizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final AuthorizationRepository authorizationRepository;

    public AuthorizationServiceImpl(AuthorizationRepository authorizationRepository) {
        this.authorizationRepository = authorizationRepository;
    }

    @Override
    public Optional<Authorization> getUserAuth(Authorization user) {
        return authorizationRepository.findAuthorizationUser(user.getEmail(), user.getPassword());
    }
}
