package com.signia.backend.util.impl;


import com.signia.backend.util.RandomCodeService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomCodeServiceImpl implements RandomCodeService {


    private String[] DATA = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    @Override
    public String generateRandomCode(Integer number) {
        String[] password = new String[number];

        for (int i = 0; i < number; i++) {
            password[i] = DATA[randomNum(0, DATA.length)];
        }

        StringBuilder newPassword = new StringBuilder();
        for (String s : password) {
            newPassword.append(s);
        }

        return String.valueOf(newPassword);
    }

    private int randomNum(int min, int max) {
        Random random = new Random();
        return random.nextInt(max) + min;
    }

}