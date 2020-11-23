package com.signia.backend.service;

import com.signia.backend.model.Authorization;
import com.signia.backend.model.Opt;

import java.util.Optional;

public interface OptService {
    Opt setOpt(Opt opt);
    Optional<Opt>getOpt(String sessionID, String code);
}
