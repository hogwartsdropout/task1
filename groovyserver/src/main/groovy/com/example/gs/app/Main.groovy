package com.example.gs.app

import com.example.grpc.OrderServiceGrpc
import com.example.grpc.OrderServiceOuterClass
import com.example.grpc.TestRequestOuterClass
import com.example.grpc.TestServiceGrpc
import io.grpc.ManagedChannelBuilder
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class Main {
    static void main(String... args) {
        SpringApplication.run(Main.class, args)
    }

    @Bean
    public CommandLineRunner demo() {
        return { args ->
            println "So groovy. Such gradle. Wow."
            println testServiceBlockingStub().send(TestRequestOuterClass.TestRequest.newBuilder()
                    .setName("Newbie")
                    .build()).greeting
            OrderServiceOuterClass.OrderSaveResponse response = orderServiceBlockingStub()
                    .save(OrderServiceOuterClass.OrderSaveRequest.newBuilder()
                    .setClient(40L)
                    .setCar(320L)
                    .setColor("RED")
                    .setStatus(OrderServiceOuterClass.OrderSaveRequest.OrderStatus.CREATED)
                    .build())
            if(response.saveStatus == OrderServiceOuterClass.OrderSaveResponse.SaveStatus.SUCCESS){
                println "Successfully saved order with id "+response.id
            }
        }
    }

    @Bean
    TestServiceGrpc.TestServiceBlockingStub testServiceBlockingStub() {
        return TestServiceGrpc.newBlockingStub(ManagedChannelBuilder.forAddress("localhost", 6565)
                .usePlaintext().build())
    }

    @Bean
    OrderServiceGrpc.OrderServiceBlockingStub orderServiceBlockingStub() {
        return OrderServiceGrpc.newBlockingStub(ManagedChannelBuilder.forAddress("localhost", 6565)
                .usePlaintext().build())
    }
}
