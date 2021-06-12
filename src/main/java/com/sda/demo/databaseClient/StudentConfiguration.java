package com.sda.demo.databaseClient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "student.config.service")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentConfiguration {
    private boolean enabled;
    private String defaultUniversityName;
}
