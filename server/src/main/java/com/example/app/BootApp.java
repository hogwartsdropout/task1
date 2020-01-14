package com.example.app;


import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;




@SpringBootApplication
@ComponentScan("com.example")
public class BootApp {
    public static void main(String ... args){
        SpringApplication.run(BootApp.class);
    }
    @Autowired
    private CustomerService customerService;
    @Bean
    public CommandLineRunner demo(CustomerService customerService){
        return (args)->{
            System.out.println("Hey there");

//            System.out.println(customerService.getCustomerById(40L).toString());
        };
    }

}
