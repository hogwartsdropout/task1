package com.example.controller;

import com.example.entity.Car;
import com.example.entity.Customer;
import com.example.entity.Order;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestRestController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/car")
    public Car getCarById(@RequestParam(name = "id", defaultValue = "290") Long id) {
        return customerService.getCarById(id);
    }

    @GetMapping("/carp/{id}")
    public Car getCarByIdInPath(@PathVariable(name = "id") Long id) {
        return customerService.getCarById(id);
    }

    @GetMapping("/cars")
    public List<Car> listAllCars() {
        return customerService.getAllCars();
    }

    @GetMapping("/customers")
    public List<Customer> listAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/orders")
    public List<Order> listAllOrders() {
        return customerService.getAllOrders();
    }

    @PostMapping("/changeorder")
    public Order changeOrder(@RequestParam(name = "id", required = true) Long id,
                             @RequestParam(name = "client", required = false) Long client,
                             @RequestParam(name = "car", required = false) Long car,
                             @RequestParam(name = "color", required = false) String color,
                             @RequestParam(name = "status", required = false) Order.Status status) {
        Order savedOrder = customerService.changeOrder(id, client, car, color, status);
        if (savedOrder != null) return savedOrder;
        return null;
    }

    @PostMapping("/addcar")
    public Car addCar(@RequestParam(name = "vendor") String vendor,
                      @RequestParam(name = "model") String model) {
        return customerService.addCar(new Car(vendor, model));
    }

    @PostMapping("/addcustomer")
    public Customer addCustomer(@RequestParam(name = "username") String username,
                                @RequestParam(name = "f_name") String f_name,
                                @RequestParam(name = "l_name") String l_name,
                                @RequestParam(name = "password") String password) {
        return customerService.addCustomer(new Customer(username, f_name, l_name, password));
    }

    @PostMapping("/addorder")
    public Order addOrder(@RequestParam(name = "client_id") Long clientId,
                          @RequestParam(name = "car_id") Long carId,
                          @RequestParam(name = "color") String colorName,
                          @RequestParam(name = "status", defaultValue = "CREATED") Order.Status status) {
        return customerService.addOrder(new Order(clientId, carId, colorName, status));
    }
    @PostMapping("/orderbyuserandstatus")
    public List<Order> getOrdersForUserWithStatus(@RequestParam(name = "client_id") Long customerId,
                                                  @RequestParam(name = "status") Order.Status status) {
        return customerService.getOrdersForUserWithStatus(customerId, status);
    }
    @DeleteMapping("/deleteorder/{id}")
    public void deleteOrder(@PathVariable(name = "id") Long id){
        customerService.deleteOrder(id);
    }
    @GetMapping("/ordersbyclient/{id}")
    public List<Order> getOrdersByClient(@PathVariable(name="id") Long id){
        return customerService.getOrdersByClient(id);
    }
}
