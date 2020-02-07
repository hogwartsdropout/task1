package com.example.gs.app

import com.example.grpc.OrderServiceGrpc
import com.example.grpc.OrderServiceOuterClass
import com.example.grpc.TestRequestOuterClass
import com.example.grpc.TestServiceGrpc
import com.example.gs.model.Order
import com.example.gs.repo.OrderRepo
import io.grpc.ManagedChannelBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories
import org.springframework.kafka.core.KafkaTemplate
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

    @Value('${autoshowroom.host}')
    String host
    @Value('${autoshowroom.port}')
    int port

    @Bean
    public CommandLineRunner demo() {
        return { args ->
            println "So groovy. Such gradle. Wow."
            println "gRpc configured to "+host+":"+port
//            println testServiceBlockingStub().send(TestRequestOuterClass.TestRequest.newBuilder()
//                    .setName("Newbie")
//                    .build()).greeting
//            Order order = new Order()
//            order.client = 40
//            order.car = 320
//            order.color = "red"
//            order.status = Order.Status.CREATED
//            println orderRepo.save(order)
//            kafkaTemplate.send("orders",order)

        }
    }

//    @Bean
//    TestServiceGrpc.TestServiceBlockingStub testServiceBlockingStub() {
//        return TestServiceGrpc.newBlockingStub(ManagedChannelBuilder.forAddress("localhost", 6565)
//                .usePlaintext().build())
//    }
//
    @Bean
    OrderServiceGrpc.OrderServiceBlockingStub orderServiceBlockingStub() {
        return OrderServiceGrpc.newBlockingStub(ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext().build())
    }
}
