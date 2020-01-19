package com.example.client.service;

import io.swagger.client.ApiException;
import io.swagger.client.api.TestRestControllerApi;
import io.swagger.client.model.Car;
import io.swagger.client.model.Customer;
import io.swagger.client.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.List;
@ShellComponent
public class CustomerService {
    @Autowired
    TestRestControllerApi testRestControllerApi;

//TODO: exception handling

    @ShellMethod("Orders in status CREATED for customer")
    public List<Order> getCreatedOrdersForCustomer(Long customerId) {
        try {
            return this.testRestControllerApi.getOrdersForUserWithStatusUsingPOST(customerId, "CREATED");
        } catch (ApiException e) {
            e.printStackTrace();
        }
        return null;
    }


    @ShellMethod("Orders in status PROGRESS for customer")
    public List<Order> getInprogressOrdersForCustomer(Long customerId) {
        try {
            return this.testRestControllerApi.getOrdersForUserWithStatusUsingPOST(customerId, "PROGRESS");
        } catch (ApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    @ShellMethod("Orders in status PROGRESS for customer")
    public List<Order> getDoneOrdersForCustomer(Long customerId) {
        try {
            return this.testRestControllerApi.getOrdersForUserWithStatusUsingPOST(customerId, "DONE");
        } catch (ApiException e) {
            e.printStackTrace();
        }
        return null;
    }

//TODO check the order of args.
    @ShellMethod("Create order")
    public Order createOrder(Long client, Long car,
                             @ShellOption(defaultValue = "white") String color,
                             @ShellOption(defaultValue ="CREATED") String status) {
        try {
            return this.testRestControllerApi.addOrderUsingPOST(client,car,color,status);
        } catch (ApiException e) {
            e.printStackTrace();
        }
        return null;
    }


    @ShellMethod("Delete order")
    public void deleteOrder(Long orderId) {
        try {
            this.testRestControllerApi.deleteOrderUsingDELETE(orderId);
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }


    @ShellMethod("Get all cars")
    public List<Car> getAllCars() {
        try {
            return testRestControllerApi.listAllCarsUsingGET();
        } catch (ApiException e) {
            e.printStackTrace();
        }
        return null;
    }


    @ShellMethod("Get All customers")
    public List<Customer> getAllCustomers() {
        try {
            return testRestControllerApi.listAllCustomersUsingGET();
        } catch (ApiException e) {
            e.printStackTrace();
        }
        return null;
    }
//TODO change the order of args.
    @ShellMethod("Change order")
    public Order changeOrder(Long id, Long client, Long car,
                             String color,
                             String status){
        try {
            return testRestControllerApi.changeOrderUsingPOST(id, client, car, color, status);
        } catch (ApiException e) {
            e.printStackTrace();
        }
        return null;
    }

}
