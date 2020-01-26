package com.example.service;

import com.example.entity.Car;
import com.example.entity.Customer;
import com.example.entity.Order;
import com.example.repository.CarRepository;
import com.example.repository.CustomerRepository;
import com.example.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Customer addCustomer(Customer customer){
        return customerRepository.save(customer)
    }
    public Car addCar(Car car){
       Car savedCar = (Car) carRepository.save(car);
       return savedCar;
    }
    public Order addOrder(Order order){

        return orderRepository.save(order);
    }

    public List<Car> getAllCars() {
        return (List<Car>) carRepository.findAll();
    }

    public List<Customer> getAllCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }

    public List<Order> getAllOrders() {
        return (List<Order>) orderRepository.findAll();
    }

    public Order changeOrder(Long id, Long client, Long car, String color, Order.Status status) {
        if (!orderRepository.existsById(id)) {
            return null;
        }
        Order orderToChange = orderRepository.findById(id).get();
        if(car!=null) orderToChange.setCar(car);
        if(color!=null) orderToChange.setColor(color);
        if(client!=null) orderToChange.setClient(client);
        if(status!=null) orderToChange.setStatus(status);
        return orderRepository.save(orderToChange);

    }
    public void deleteOrder(Long id){
        orderRepository.deleteById(id);
    }
    public List<Order> getOrdersForUserWithStatus(Long customerId, Order.Status status){
        return orderRepository.getOrdersByClientAndStatus(customerId,status);
    }
    public List<Order> getOrdersByClient(Long id){
        return orderRepository.getOrdersByClient(id);
    }
}
