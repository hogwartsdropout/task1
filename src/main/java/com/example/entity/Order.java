package com.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id", updatable = false, nullable = false)
    private long id;
    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "client_id", nullable = false)
    private long client;
    @ManyToOne(targetEntity = Car.class)
    @JoinColumn(name="car_id", nullable = false)
    private long car;
    private String color;
    private String status;
}
