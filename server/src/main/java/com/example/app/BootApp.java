package com.example.app;


import com.example.entity.Car;
import com.example.entity.Customer;
import com.example.entity.Order;
import com.example.service.CustomerService;
import com.example.service.ws.CustomerWebService;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import javax.xml.ws.Endpoint;


@SpringBootApplication
@ComponentScan("com.example")
@EnableJpaRepositories("com.example.repository")
@EnableAutoConfiguration
@EnableTransactionManagement
@EntityScan("com.example.entity")
public class BootApp {
    public static void main(String... args) {
        SpringApplication.run(BootApp.class);
    }

    @Autowired
    private CustomerWebService customerWebService;

    @Bean
    public CommandLineRunner demo(CustomerService customerService) {
        return (args) -> {
            System.out.println("Hey there");
        };
    }

    @Bean
    public SpringBus cxf() {
        return new SpringBus();
    }

    @Bean
    public Endpoint customerServiceEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(cxf(), customerWebService);
        endpoint.publish("/customerService");
        return endpoint;
    }


}
