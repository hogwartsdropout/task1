package com.example.service;

import com.example.entity.Customer;
import com.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private CustomerRepository repository;
    @Autowired
    private CustomerService(CustomerRepository repository){
        this.repository = repository;
    }
    public Customer getCustomer(long id){
        return repository.findOne(id);
    }
}
