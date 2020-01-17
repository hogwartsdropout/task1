package com.example.repository;

import com.example.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long>{
    List<Order> getOrdersByClientAndStatus(Long client, Order.Status status);
    List<Order> getOrdersByClient(Long client);
}
