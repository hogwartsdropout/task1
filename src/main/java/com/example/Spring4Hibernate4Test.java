package com.example;

import com.example.repository.CustomerRepository;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.AppConfig;
import com.example.dao.IPersonDao;

public class Spring4Hibernate4Test {

  public static void main(String[] args) {
	  AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
  	  ctx.register(AppConfig.class);
	  ctx.refresh();
	  IPersonDao pdao = ctx.getBean(IPersonDao.class);
	  CustomerService customerService = ctx.getBean((CustomerService.class));
//	  pdao.saveClient();
	  System.out.println(customerService.getCustomer(40L));
	  System.out.println("Done");
  }
}
