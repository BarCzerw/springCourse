package com.sda.demo.zadania.dummyLogger.logger;

public class DummyService implements SimpleLogger {

    @Override
    public void printMessage(String message) {
        System.out.println("--" + message);
    }
}
