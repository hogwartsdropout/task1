package com.example.app;


import com.example.service.CustomerService;
import com.example.service.ws.CustomerWebService;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.sql.DataSource;
import javax.xml.ws.Endpoint;


@SpringBootApplication
@ComponentScan("com.example")
public class BootApp {
    public static void main(String ... args){
        SpringApplication.run(BootApp.class);
    }
    @Autowired
    private CustomerWebService customerWebService;
    @Bean
    public CommandLineRunner demo(CustomerService customerService){
        return (args)->{
            System.out.println("Hey there");
        };
    }

    @Bean
    public SpringBus cxf(){return new SpringBus();}

    @Bean
    public Endpoint customerServiceEndpoint(){
        EndpointImpl endpoint = new EndpointImpl(cxf(), customerWebService);
        endpoint.publish("/customerService");
        return endpoint;
    }

}
