package com.sda.demo.zadania.dummyLogger.logger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UtilConfigure {

    @Bean
    public DummyService dummyService(){
        return new DummyService();
    }

}
