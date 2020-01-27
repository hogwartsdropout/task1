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
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;
    private OrderRepository orderRepository;
    private CarRepository carRepository;
    Logger logger = Logger.getLogger("SOAP service");

    @Autowired
    private CustomerService(CustomerRepository customerRepository, CarRepository carRepository, OrderRepository orderRepository) {
        this.customerRepository = customerRepository;
        this.carRepository = carRepository;
        this.orderRepository = orderRepository;
    }

    public Customer getCustomerById(long id) {
        return customerRepository.findById(id).get();
    }

    public Car getCarById(long id) {
        logger.log(Level.FINE, "Get car by id " + id);
        return carRepository.findById(id).get();
    }

    public Customer addCustomer(Customer customer) {
        logger.log(Level.FINE, "Add customer: " + customer);
        return customerRepository.save(customer);
    }

    public Car addCar(Car car) {
        logger.log(Level.FINE, "Add car." + car);
        Car savedCar = (Car) carRepository.save(car);
        return savedCar;
    }

    public Order addOrder(Order order) {
        logger.log(Level.FINE, "Add order: " + order);
        return orderRepository.save(order);
    }

    public List<Car> getAllCars() {
        logger.log(Level.FINE, "Get all cars ");
        return (List<Car>) carRepository.findAll();
    }

    public List<Customer> getAllCustomers() {
        logger.log(Level.FINE, "Get all customers ");
        return (List<Customer>) customerRepository.findAll();
    }

    public List<Order> getAllOrders() {
        logger.log(Level.FINE, "Get all orders ");
        return (List<Order>) orderRepository.findAll();
    }

    public Order changeOrder(Long id, Long client, Long car, String color, Order.Status status) {
        logger.log(Level.FINE, "Change order ");
        if (!orderRepository.existsById(id)) {
            return null;
        }
        Order orderToChange = orderRepository.findById(id).get();
        if (car != null) orderToChange.setCar(car);
        if (color != null) orderToChange.setColor(color);
        if (client != null) orderToChange.setClient(client);
        if (status != null) orderToChange.setStatus(status);
        return orderRepository.save(orderToChange);

    }

    public void deleteOrder(Long id) {
        logger.log(Level.FINE, "Delete order with id " + id);
        orderRepository.deleteById(id);
    }

    public List<Order> getOrdersForUserWithStatus(Long customerId, Order.Status status) {
        logger.log(Level.FINE, "Get all orders in status " + status + "for customer " + customerId);
        return orderRepository.getOrdersByClientAndStatus(customerId, status);
    }

    public List<Order> getOrdersByClient(Long id) {
        logger.log(Level.FINE, "Delete order with id " + id);
        return orderRepository.getOrdersByClient(id);
    }
}
