package com.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "\"order\"")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id", updatable = false, nullable = false)
    private long id;
//    @ManyToOne(targetEntity = Customer.class)
//    @JoinColumn(name = "client_id", nullable = false)
    @Column(name="client_id", nullable = false)
    private Long client;
//    @ManyToOne(targetEntity = Car.class)
//    @JoinColumn(name="car_id", nullable = false)
    @Column(name="car_id", nullable = false)
    private Long car;
    private String color;
    private String status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getClient() {
        return client;
    }

    public void setClient(Long client) {
        this.client = client;
    }

    public Long getCar() {
        return car;
    }

    public void setCar(Long car) {
        this.car = car;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Order(long client, long car, String color, String status) {
        this.client = client;
        this.car = car;
        this.color = color;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", client=" + client +
                ", car=" + car +
                ", color='" + color + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
