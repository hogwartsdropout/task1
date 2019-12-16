package com.example;

import com.example.entity.Car;
import com.example.entity.Customer;
import com.example.entity.Order;
import com.example.service.CustomerService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.AppConfig;
import com.example.dao.ITestDao;

public class Spring4Hibernate4Test {


  public static void main(String[] args) {
	  AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
  	  ctx.register(AppConfig.class);
	  ctx.refresh();
	  ITestDao testDao = ctx.getBean(ITestDao.class);
	  CustomerService customerService = ctx.getBean((CustomerService.class));
	  testDao.saveOrder(new Order(40L,320L,"white","CREATED"));
	  customerService.addCar(new Car("abc", "def"));
	  customerService.addCustomer(new Customer("asdf","Qwer","Ty", null));
	  System.out.println(customerService.getCustomerById(40L));
	  System.out.println("Done");
  }
}
