package com.example.soapclient.service.impl;

import com.example.service.ws.impl.Customer;
import com.example.service.ws.impl.CustomerWebServiceImpl;
import com.example.soapclient.service.CustomerService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.stereotype.Service;

@Service
@ShellComponent
public class CustomerServiceImpl implements CustomerService {
private CustomerWebServiceImpl customerWebService;

public CustomerServiceImpl(){
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
}
