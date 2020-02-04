package com.example.gs.model

import org.springframework.data.cassandra.core.mapping.PrimaryKey
import org.springframework.data.cassandra.core.mapping.Table

@Table("orders")
class Order {
    @PrimaryKey
    private UUID id = UUID.randomUUID()
    private long client
    private long car
    private String color
    private Status status
    public enum Status{
        CREATED,PROGRESS,DONE
    }
    UUID getId() {
        return id
    }

    void setId(UUID id) {
        this.id = id
    }
    long getClient() {
        return client
    }

    void setClient(long client) {
        this.client = client
    }

    long getCar() {
        return car
    }

    void setCar(long car) {
        this.car = car
    }

    String getColor() {
        return color
    }

    void setColor(String color) {
        this.color = color
    }

    Status getStatus() {
        return status
    }

    void setStatus(Status status) {
        this.status = status
    }
//    Order(long client,long car,String color,Status status){
//
//    }

}
