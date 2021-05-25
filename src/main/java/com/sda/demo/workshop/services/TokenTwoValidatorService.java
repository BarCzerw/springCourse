package com.sda.demo.workshop.services;

import org.springframework.stereotype.Service;

@Service
public class TokenTwoValidatorService implements ValidatorService{
    @Override
    public boolean isValid(String token) {
        return token.startsWith("is");
    }
}
