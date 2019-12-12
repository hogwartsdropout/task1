package com.example.entity;

import javax.persistence.*;

@Entity
@Table(name="person")
public class Person { 
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="id", updatable = false, nullable = false)
    private int id;  
	@Column(name="name", nullable = false)
    private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
