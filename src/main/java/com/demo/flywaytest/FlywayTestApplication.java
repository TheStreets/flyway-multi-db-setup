package com.demo.flywaytest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.awt.print.Book;

@SpringBootApplication
public class FlywayTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlywayTestApplication.class, args);
    }

}
