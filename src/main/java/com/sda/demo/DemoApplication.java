package com.sda.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoPeriod;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/hello")
    public String sayHello(
            @RequestParam(value = "myName", defaultValue = "World") String name,
            @RequestParam(value = "mySurname", defaultValue = "Kowalski") String surname) {
        return String.format("Hello %s %s!", name, surname);
    }

    @GetMapping("/premium")
    public String calculatePremium(@RequestParam(value = "code", defaultValue = "empty") String code) {
        return code.equals("super") ? "Winner!" : "Try again...";
    }

    @GetMapping("/isEven")
    //requestParam accepts
    public String isEven(@RequestParam(value = "number", defaultValue = "2") Integer number) {
        return number % 2 == 0 ? number + " is even" : number + " is odd";
    }

    @GetMapping("/left")
    public String calculateLeft() {
        return "Days till 2021-06-30 - " + ChronoUnit.DAYS.between(LocalDateTime.now(), LocalDateTime.of(2021, 6, 30, 0, 0));
    }

    @GetMapping("/search")
    public String contains(@RequestParam(value = "text") String text, @RequestParam(value = "token", defaultValue = "kotCzarodziej") String token) {
        return text.contains(token) ? "Text contains '" + token + "'" : "Text does not contain '" + token + "'";
    }



}
