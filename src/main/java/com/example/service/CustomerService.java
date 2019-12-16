package com.example.service;

import com.example.entity.Car;
import com.example.entity.Customer;
import com.example.entity.Order;
import com.example.repository.CarRepository;
import com.example.repository.CustomerRepository;
import com.example.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;
    private OrderRepository orderRepository;
    private CarRepository carRepository;
    @Autowired
    private CustomerService(CustomerRepository customerRepository, CarRepository carRepository, OrderRepository orderRepository){
        this.customerRepository = customerRepository;
        this.carRepository = carRepository;
        this.orderRepository = orderRepository;
    }
    public Customer getCustomerById(long id){
        return customerRepository.findById(id).get();
    }
    public Car getCarById(long id){return carRepository.findById(id).get();}
    public void addCustomer(Customer customer){
        customerRepository.save(customer);
    }
    public void addCar(Car car){
       Car savedCar = (Car) carRepository.save(car);
    }
    public void addOrder(Order order){
        orderRepository.save(order);
    }

}
