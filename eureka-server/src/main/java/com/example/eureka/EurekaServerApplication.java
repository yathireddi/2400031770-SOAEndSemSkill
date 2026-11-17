package com.example.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Service Registry.
 * Every microservice registers itself here so other services
 * (like the API Gateway) can find it by name instead of by IP/port.
 */
@SpringBootApplication
@EnableEurekaServer // turns this app into a Eureka discovery server
public class EurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}
