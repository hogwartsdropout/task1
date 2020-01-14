package com.example.dao;

import javax.transaction.Transactional;

import com.example.entity.Car;
import com.example.entity.Customer;
import com.example.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.entity.Person;
import org.springframework.orm.hibernate5.HibernateTemplate;

@Transactional
public class TestDao implements ITestDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public void saveClient(){
		Customer client = new Customer();
		client.setUsername("lll");
		client.setFName("Ivan");
		client.setLName("Ivanov");
		hibernateTemplate.save(client);
	}
	public void saveCustomer(Customer customer){
		hibernateTemplate.save(customer);
	}
	public void saveCar(Car carToSave){
		hibernateTemplate.save(carToSave);
	}

	@Override
	public void saveOrder(Order order) {
		hibernateTemplate.save(order);
	}
}
