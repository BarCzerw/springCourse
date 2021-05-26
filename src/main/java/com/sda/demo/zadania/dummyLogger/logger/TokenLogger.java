package com.sda.demo.zadania.dummyLogger.logger;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TokenLogger implements SimpleLogger{
    @Override
    public void printMessage(String message) {
        log.info("[randomToken] " + message);
    }
}
