package com.example.client.config;

import io.swagger.client.ApiClient;
import io.swagger.client.api.TestRestControllerApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public ApiClient getApiClient() {
        return new ApiClient();
    }

    @Bean
    public TestRestControllerApi getRestControllerApi() {
        return new TestRestControllerApi(getApiClient());
    }
}
