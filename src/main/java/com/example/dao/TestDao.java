package com.example.dao;

import javax.transaction.Transactional;

import com.example.entity.Car;
import com.example.entity.Customer;
import com.example.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.example.entity.Person;

@Transactional
public class TestDao implements ITestDao {
	@Autowired
	private HibernateTemplate  hibernateTemplate;
	public void savePerson() {
		Person person = new Person();
//		person.setId(1);
		person.setName("Ram");
		hibernateTemplate.save(person);

	}
	public void saveClient(){
		Customer client = new Customer();
		client.setUsername("lll");
		client.setFName("Ivan");
		client.setLName("Ivanov");
		hibernateTemplate.save(client);
	}
	public void saveCar(Car carToSave){
		hibernateTemplate.save(carToSave);
	}

	@Override
	public void saveOrder(Order order) {
		hibernateTemplate.save(order);
	}
}
