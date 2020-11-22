package com.signia.backend.util.impl;

import com.signia.backend.util.CheckDataService;
import org.springframework.stereotype.Service;

import java.time.*;

@Service
public class CheckDataServiceImpl implements CheckDataService {
    private static float LIMITED = 30;

    @Override
    public Boolean checkDate(ZonedDateTime data) {
        ZonedDateTime now = ZonedDateTime.now();
        Duration duration = Duration.between(data, now);
        long secondsPassed = duration.getSeconds();
        return secondsPassed < LIMITED;
    }
}