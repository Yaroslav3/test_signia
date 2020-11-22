package com.signia.backend.service;

import com.signia.backend.model.Authorization;

import java.util.Optional;

public interface AuthorizationService {

    Optional<Authorization> getUserAuth(Authorization user);
}
