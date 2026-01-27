package com.bfellas.digimenu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "repository")
@EntityScan(basePackages = "entity")
@ComponentScan(basePackages = {
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