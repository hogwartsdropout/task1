package com.example.wfapp.model;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;
@Table("orders")
public class Order {
    @PrimaryKey
    private UUID id;
    private long client;
    private long car;
    private String color;
    private Status status;

    public enum Status {
        CREATED, PROGRESS, DONE
    }
    public Order(){}

    public Order(long client, long car, String color, String status) {
        this.client = client;
        this.car = car;
        this.color = color;
        this.status = Status.valueOf(status);
    }

    public Order(Order order, UUID id) {
        this.id = id;
        this.client = order.client;
        this.car = order.car;
        this.color = order.color;
        this.status = order.status;
    }

    public UUID getId() {
        return id;
    }

    void setId(UUID id) {
        this.id = id;
    }

    public long getClient() {
        return client;
    }

    public void setClient(long client) {
        this.client = client;
    }

    public long getCar() {
        return car;
    }

    public void setCar(long car) {
        this.car = car;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    public void setStatus(String status){
        this.status = Status.valueOf(status);
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
