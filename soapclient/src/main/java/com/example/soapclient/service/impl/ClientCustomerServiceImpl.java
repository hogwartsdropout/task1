package com.example.soapclient.service.impl;

import com.example.service.ws.impl.Car;
import com.example.service.ws.impl.Customer;
import com.example.service.ws.impl.CustomerWebServiceImpl;
import com.example.service.ws.impl.Order;
import com.example.service.ws.impl.Status;
import com.example.soapclient.service.ClientCustomerService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ShellComponent
public class ClientCustomerServiceImpl implements ClientCustomerService {
private CustomerWebServiceImpl customerWebService;

public ClientCustomerServiceImpl(){
   com.example.service.ws.impl.CustomerService cc =
            new com.example.service.ws.impl.CustomerService();
    this.customerWebService = cc.getCustomerServicePort();
}
    @Override
    @ShellMethod("Get customer by id")
    public String getCustomerById(Long id) {
        Customer customer = this.customerWebService.getCustomerById(id);
    return customer.toString();
    }

    @Override
    @ShellMethod("Orders in status CREATED for customer")
    public List<Order> getCreatedOrdersForCustomer(Long customerId) {
    return this.customerWebService.getOrdersForUserWithStatus(customerId, Status.CREATED);
    }

    @Override
    @ShellMethod("Orders in status PROGRESS for customer")
    public List<Order> getInprogressOrdersForCustomer(Long customerId) {
        return this.customerWebService.getOrdersForUserWithStatus(customerId, Status.PROGRESS);
    }

    @Override
    @ShellMethod("Orders in status PROGRESS for customer")
    public List<Order> getDoneOrdersForCustomer(Long customerId) {
        return this.customerWebService.getOrdersForUserWithStatus(customerId, Status.DONE);
    }

    @Override
    @ShellMethod("Create order")
    public Order createOrder(Long client, Long car,
                             @ShellOption(defaultValue = "white") String color,
                             @ShellOption(defaultValue ="CREATED") Status status) {
        return this.customerWebService.createOrder(client,car,color,status);
    }

    @Override
    @ShellMethod("Delete order")
    public void deleteOrder(Long orderId) {
        this.customerWebService.deleteOrder(orderId);
    }

    @Override
    @ShellMethod("Get all cars")
    public List<Car> getAllCars() {
        return customerWebService.getAllCars();
    }

    @Override
    @ShellMethod("Get All customers")
    public List<Customer> getAllCustomers() {
        return customerWebService.getAllCustomers();
    }
    @Override
    @ShellMethod("Change order")
    public Order changeOrder(Long id, Long client, Long car,
                              String color,
                              Status status){
    return customerWebService.changeOrder(id, client, car, color, status);
    }


}
