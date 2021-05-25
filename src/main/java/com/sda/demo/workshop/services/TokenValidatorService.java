package com.sda.demo.workshop.services;

import org.springframework.stereotype.Service;

/*Service to validate token*/

@Service
public class TokenValidatorService implements ValidatorService{

    public boolean isValid(String token){
        return token.endsWith("able");
    }

}
