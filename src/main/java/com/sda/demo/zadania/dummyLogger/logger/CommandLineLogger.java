package com.sda.demo.zadania.dummyLogger.logger;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineLogger implements CommandLineRunner {

    @Autowired
    private TokenLogger tokenLogger;

    @Autowired
    private DummyService dummyService;

    @Override
    public void run(String... args) throws Exception {
        tokenLogger.printMessage("App running!");
        dummyService.printMessage("New message!");
    }
}
