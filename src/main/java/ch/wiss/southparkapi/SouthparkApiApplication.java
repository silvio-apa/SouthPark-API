package ch.wiss.southparkapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Starts the South Park REST API application.
 */

@SpringBootApplication
public class SouthparkApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SouthparkApiApplication.class, args);
    }

}
