package com.signia.backend.service.impl;

import com.signia.backend.model.Opt;
import com.signia.backend.repository.OptRepository;
import com.signia.backend.service.OptService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OptServiceImpl implements OptService {
    private final OptRepository optRepository;

    public OptServiceImpl(OptRepository optRepository) {
        this.optRepository = optRepository;
    }

    @Override
    public Opt setOpt(Opt opt) {
        return optRepository.save(opt);
    }

    @Override
    public Optional<Opt> getOpt(String sessionID, String code) {
        return optRepository.findSessionId(sessionID, code);
    }
}
