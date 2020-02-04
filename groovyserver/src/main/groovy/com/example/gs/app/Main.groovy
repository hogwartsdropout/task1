package com.example.gs.app

import com.example.grpc.OrderServiceGrpc
import com.example.grpc.OrderServiceOuterClass
import com.example.grpc.TestRequestOuterClass
import com.example.grpc.TestServiceGrpc
import com.example.gs.model.Order
import com.example.gs.repo.OrderRepo
import io.grpc.ManagedChannelBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@SpringBootApplication
@EnableCassandraRepositories("com.example.gs.repo")
@ComponentScan("com.example.gs")
class Main {
    static void main(String... args) {
        SpringApplication.run(Main.class, args)
    }
    @Autowired
    OrderRepo orderRepo

    @Bean
    public CommandLineRunner demo() {
        return { args ->
            println "So groovy. Such gradle. Wow."
            println testServiceBlockingStub().send(TestRequestOuterClass.TestRequest.newBuilder()
                    .setName("Newbie")
                    .build()).greeting
//            OrderServiceOuterClass.OrderSaveResponse response = orderServiceBlockingStub()
//                    .save(OrderServiceOuterClass.OrderSaveRequest.newBuilder()
//                    .setClient(40L)
//                    .setCar(320L)
//                    .setColor("RED")
//                    .setStatus(OrderServiceOuterClass.OrderSaveRequest.OrderStatus.CREATED)
//                    .build())
//            if(response.saveStatus == OrderServiceOuterClass.OrderSaveResponse.SaveStatus.SUCCESS){
//                println "Successfully saved order with id "+response.id
//            }
            Order order = new Order()
//            order.id = UUID.randomUUID()
            order.client = 40
            order.car = 320
            order.color = "red"
            order.status = Order.Status.CREATED
            println orderRepo.save(order)

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
