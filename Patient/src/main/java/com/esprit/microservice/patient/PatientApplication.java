package com.esprit.microservice.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
@EnableDiscoveryClient
public class PatientApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientApplication.class, args);
    }

    @Autowired
    private PatientRepository repository;

    @Bean
    ApplicationRunner init() {
        return (args) -> {
            repository.save(new Patient("John", "Doe", new Date(), "123 Main St", "1234567890", "john@example.com"));
            repository.save(new Patient("Jane", "Smith", new Date(), "456 Elm St", "0987654321", "jane@example.com"));
            repository.save(new Patient("Alice", "Johnson", new Date(), "789 Oak St", "5555555555", "alice@example.com"));
            repository.save(new Patient("Bob", "Williams", new Date(), "101 Pine St", "6666666666", "bob@example.com"));

            repository.findAll().forEach(System.out::println);
        };
    }
}
