package com.example.kafka;

import com.example.entity.Order;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class ListenAndSave {
    Logger logger = Logger.getLogger("kafka.ListenAndSave");
    @Autowired
    CustomerService service;
    @KafkaListener(topics ="orders",groupId = "autoshowroom")
    public void listen(com.example.gs.model.Order order){
        Order orderToSave = new Order();
        orderToSave.setClient(order.getClient());
        orderToSave.setCar(order.getCar());
        orderToSave.setColor(order.getColor());
        orderToSave.setStatus(Order.Status.valueOf(order.getStatus().name()));
        System.out.println("Saving order: \n"+order);
        try{
            service.addOrder(orderToSave);
        }catch(Exception e){
            logger.log(Level.ALL,"Unable to save an order:\n"+order.toString());
        }

    }
}
