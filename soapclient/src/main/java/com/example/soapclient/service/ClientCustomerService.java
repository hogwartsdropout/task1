package com.example.soapclient.service;

import com.example.service.ws.impl.Car;
import com.example.service.ws.impl.Customer;
import com.example.service.ws.impl.Order;
import com.example.service.ws.impl.Status;

import java.util.List;

public interface ClientCustomerService {
    String getCustomerById(Long id);

    List<Order> getCreatedOrdersForCustomer(Long customerId);

    List<Order> getInprogressOrdersForCustomer(Long customerId);

    List<Order> getDoneOrdersForCustomer(Long customerId);

    Order createOrder(Long clientId, Long carId, String color, Status status);

    void deleteOrder(Long orderId);

    List<Car> getAllCars();

    List<Customer> getAllCustomers();

    Order changeOrder(Long id, Long client, Long car,
                      String color,
                      Status status);
}
