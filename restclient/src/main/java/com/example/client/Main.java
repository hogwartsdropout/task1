package com.example.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class Main {
    public static void  main(String ... args){
        SpringApplication.run(Main.class);
    }

    @Bean
    WebClient webClient() {
        return WebClient.builder().baseUrl("http://localhost:8080").build();
    }

}
