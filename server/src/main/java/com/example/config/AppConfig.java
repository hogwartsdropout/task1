package com.example.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import com.example.entity.Car;
import com.example.entity.Customer;
import com.example.entity.Order;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.example.dao.ITestDao;
import com.example.dao.TestDao;
import com.example.entity.Person;

@org.springframework.context.annotation.Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.example.repository")
@ComponentScan("com.example")
public class AppConfig {
    @Bean
    public ITestDao personDao() {
        return new TestDao();
    }

    @Bean
    public HibernateTemplate hibernateTemplate() {
        return new HibernateTemplate(sessionFactory());
    }

    @Bean(name = "entityManagerFactory")
    public SessionFactory sessionFactory() {

        Configuration cfg = new Configuration()
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Car.class).addAnnotatedClass(Order.class);
        return cfg.buildSessionFactory();

    }




}