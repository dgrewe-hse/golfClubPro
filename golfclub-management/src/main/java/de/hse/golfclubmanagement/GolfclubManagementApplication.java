package de.hse.golfclubmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the Golfclub Management Spring Boot application.
 */
@SpringBootApplication
public class GolfclubManagementApplication {

    /**
     * The main method that starts the Spring Boot application.
     * 
     * @param args command line arguments (if any)
     */
    public static void main(String[] args) {
        SpringApplication.run(GolfclubManagementApplication.class, args);
    }
}
