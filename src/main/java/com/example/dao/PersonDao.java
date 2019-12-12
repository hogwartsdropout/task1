package com.example.dao;

import javax.transaction.Transactional;

import com.example.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.example.entity.Person;

@Transactional
public class PersonDao implements IPersonDao {
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
		client.setUsername("Loltro");
		client.setFName("Ivan");
		client.setLName("Ivanov");
		hibernateTemplate.save(client);
	}
}
