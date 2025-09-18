package ru.practicum.stat.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class StatApplication {
    public static void main(String[] args) {
        SpringApplication.run(StatApplication.class, args);
    }
}
