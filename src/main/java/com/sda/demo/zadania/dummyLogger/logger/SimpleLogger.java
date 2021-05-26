package com.sda.demo.zadania.dummyLogger.logger;

import org.springframework.stereotype.Service;

@Service
public interface SimpleLogger {
    void printMessage(String message);

}
