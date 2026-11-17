package com.example.appservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main microservice (app-service).
 * Exposes REST APIs and stores data in the PostgreSQL container (app-db).
 * Registers itself with Eureka automatically (eureka client is on the classpath).
 */
@SpringBootApplication
public class AppServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppServiceApplication.class, args);
    }
}
