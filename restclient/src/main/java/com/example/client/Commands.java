package com.example.client;


import io.swagger.client.ApiException;
import io.swagger.client.api.TestRestControllerApi;
import io.swagger.client.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.reactive.ClientHttpRequest;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.reactive.function.BodyInserter;

import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@ShellComponent
public class Commands {
    @Autowired
    TestRestControllerApi testRestControllerApi;
    @Autowired
    WebClient webClient;
    Logger LOGGER = Logger.getLogger("RestClient");
    @ShellMethod("Add car")
    public String addCar(String vendor, String model){
        LOGGER.log(Level.ALL,"adding a car: "+vendor+" "+model);
        LinkedMultiValueMap<String,String> map = new LinkedMultiValueMap<>();
        map.add("vendor", vendor);
        map.add("model",model);
        BodyInserters.MultipartInserter bodyInserter
                = BodyInserters.fromMultipartData(map);
        WebClient.UriSpec<WebClient.RequestBodySpec> request = webClient.post();
        WebClient.RequestHeadersSpec requestSpec1 = webClient
                .method(HttpMethod.POST)
                .uri("/addcar")
                .body(bodyInserter);
        String response = requestSpec1.retrieve().bodyToMono(String.class).block();
        return response;
    }

    @ShellMethod("List all orders")
    public List<Order> getAllOrders(){
        try {
            return testRestControllerApi.listAllOrdersUsingGET();
        } catch (ApiException e) {
            e.printStackTrace();
        }
        return null;
    }

}
