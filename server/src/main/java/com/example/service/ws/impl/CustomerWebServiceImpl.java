package com.example.service.ws.impl;

import com.example.entity.Car;
import com.example.entity.Customer;
import com.example.entity.Order;
import com.example.service.CustomerService;
import com.example.service.ws.CustomerWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import java.util.List;
@Component
@WebService(serviceName="customerService", portName = "customerServicePort")
public class CustomerWebServiceImpl implements CustomerWebService {
    @Autowired
    private CustomerService service;

    public CustomerWebServiceImpl() {

    }

    @Override
    public Customer getCustomerById(long id) {
        return service.getCustomerById(id);
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return service.addCustomer(customer);
    }

    @Override
    public Car addCar(Car car) {
        return service.addCar(car);
    }

    @Override
    public List<Car> getAllCars() {
        return service.getAllCars();
    }

    @Override
    public List<Customer> getAllCustomers() {
        return service.getAllCustomers();
    }

    @Override
    public List<Order> getAllOrders() {
        return service.getAllOrders();
    }

    @Override
    public Order changeOrder(Long id, Long client, Long car, String color, Order.Status status) {
        return service.changeOrder(id,client,car,color, status);
    }
}
