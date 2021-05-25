package com.sda.demo.workshop.rest;

import com.sda.demo.workshop.model.Workshop;
import com.sda.demo.workshop.services.ValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class RestWorkshops {

    @Autowired
    //qualifier wskazuje ktory service z interfejsu ValidatorService uzyc, jak jest 1 tylko to bedzie wiedzial, jak wiecej, to trzeba wskazac
    @Qualifier(value = "tokenTwoValidatorService")
    //w service mozna dodac @Primary i wtedy nie trzeba korzystac z qualifier
    private ValidatorService validatorService;

    @GetMapping("/workshops")
    public List<Workshop> getWorkshopsList(@RequestParam String token) {
        if (validatorService.isValid(token)) {
            return List.of(new Workshop("ABC", "Gdańsk"),
                    new Workshop("DEF", "Warszawa"),
                    new Workshop("GHI", "Szczecin"));
        }else{
            return Collections.emptyList();
        }
    }

}
