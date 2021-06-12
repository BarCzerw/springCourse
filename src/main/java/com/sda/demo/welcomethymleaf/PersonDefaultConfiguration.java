package com.sda.demo.welcomethymleaf;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "person.config")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDefaultConfiguration {
    private String defaultFirstName;
    private String defaultLastName;
    private int defaultAge;
}
