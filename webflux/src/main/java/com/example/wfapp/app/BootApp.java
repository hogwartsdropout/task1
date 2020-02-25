package com.example.wfapp.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories;

@SpringBootApplication
@ComponentScan("com.example.wfapp")
@EnableReactiveCassandraRepositories("com.example.wfapp.repo")
public class BootApp {
    public static void main(String[] args) {
        SpringApplication.run(BootApp.class);
    }
}
