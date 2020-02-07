package com.example.gs.model;

import java.util.UUID;
//Order types on groovy and java servers differ in id field type.
//This is the only reason for this class to exist.
//TODO: find a way to get rid of it.
public class Order {
    private UUID id ;
    private long client;
    private long car;
    private String color;
    private Status status;
    public enum Status{
        CREATED,PROGRESS,DONE
    }
    UUID getId() {
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
