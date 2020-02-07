package com.example.gs.controller

import com.example.gs.grpc.OrderGrpcClient
import com.example.gs.model.Order
import com.example.gs.model.Order.Status
import com.example.gs.repo.OrderRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping('')
class OrderRestController {
    @Autowired
    OrderRepo orderRepo
    @Autowired
    OrderGrpcClient grpcClient
    @Autowired
    KafkaTemplate<String,Order> kafkaTemplate

    @PostMapping('addorder')
    Order saveOrder(@RequestParam(name = "client_id") long client,
                          @RequestParam(name = "car_id") long car,
                          @RequestParam(name = "color") String color,
                          @RequestParam(name = "status") Status status) {
        Order orderToSave = new Order()
        orderToSave.client =client
        orderToSave.car=car
        orderToSave.color=color
        orderToSave.status=status
        return orderRepo.save(orderToSave)
    }
    @PostMapping('/aogrpc')
    public Order addOrderViaGRpc(@RequestBody Order order){
        println grpcClient.save(order)
        return orderRepo.save(order)
    }
    @PostMapping('/aokafka')
    public Order addOrderViaKafka(@RequestBody Order order){
        kafkaTemplate.send("orders",order)
        return orderRepo.save(order)
    }
}
