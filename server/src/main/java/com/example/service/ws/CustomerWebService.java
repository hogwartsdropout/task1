package com.example.service.ws;

import com.example.entity.Car;
import com.example.entity.Customer;
import com.example.entity.Order;

import java.util.List;

public interface CustomerWebService {
    Customer getCustomerById(long id);
     Customer addCustomer(Customer customer);
     Car addCar(Car car);
    List<Car> getAllCars();
    List<Customer> getAllCustomers();
    List<Order> getAllOrders();
    Order changeOrder(Long id, Long client, Long car, String color, Order.Status status);
    List<Order> getOrdersForUserWithStatus(Long customerId, Order.Status status);
    void deleteOrder(Long id);
    Car getCarById(Long id);
    Order createOrder(Long client, Long car, String color, Order.Status status);
    List<Order>getAllOrdersForCustomerById(Long customerId);

}
