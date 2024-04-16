package com.neosoft.tondeuse.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.neosoft.tondeuse")
public class TondeuseApplication {
    public static void main(String[] args) {
        SpringApplication.run(TondeuseApplication.class, args);
    }
}
