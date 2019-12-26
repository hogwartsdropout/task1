package com.example.app;

import com.example.dao.ITestDao;
import com.example.dao.TestDao;
import com.example.entity.Car;
import com.example.entity.Customer;
import com.example.entity.Order;
import com.example.entity.Person;
import com.example.service.CustomerService;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;



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
