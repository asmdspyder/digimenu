package com.bfellas.digimenu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "com.bfellas.digimenu",
        "controller",
        "service",
        "repository",
        "entity",
        "dto"
})
public class DigimenuApplication {

    public static void main(String[] args) {
        SpringApplication.run(DigimenuApplication.class, args);
    }
}