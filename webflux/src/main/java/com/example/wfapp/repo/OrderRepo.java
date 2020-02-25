package com.example.wfapp.repo;

import com.example.wfapp.model.Order;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface OrderRepo extends ReactiveCrudRepository<Order, UUID> {
}
