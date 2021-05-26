package com.sda.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoPeriod;
import java.time.temporal.ChronoUnit;
import java.util.Random;

@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/hello")
    public String sayHello(
            @RequestParam(value = "myName", defaultValue = "World") String name,
            @RequestParam(value = "mySurname", defaultValue = "Kowalski") String surname,
            @RequestParam(value = "myAge", defaultValue = "99") int age ) {
        return String.format("Hello %s %s! Age - %s", name, surname, age);
    }

    @GetMapping("/lottery")
    public String lottery(@RequestParam(value = "playerNumber") int playerNumber){
        final int drawNumber = new Random().nextInt(10)+1;

        return "<p>Drawn number: " + drawNumber + "</p>" +
                "<p>Player number: " + playerNumber + "</p>" +
                (drawNumber==playerNumber ? "<h2>You win!</h2>" : "<h2>Try next time...</h2>")+
                "<a href=\"lottery.html\"><h1>Lottery!</h1></a>";
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
