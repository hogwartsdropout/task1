package com.example.wfapp.config;

import com.example.wfapp.handler.OrderHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static reactor.core.publisher.Mono.just;

@Configuration
public class RouterFunctionConfig {
    @Bean
    public RouterFunction<?> routerFunction(OrderHandler orderHandler){
        return route(GET("/hello"),request -> ok().body(just("Hello world!"),String.class))
                .andRoute(GET("/order/{id}").and(accept(APPLICATION_JSON)), orderHandler::get)
                .andRoute(POST("/order").and(accept(APPLICATION_JSON)),orderHandler::add);
    }
}
