package com.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id", updatable = false, nullable = false)
    private Long id;
    private String vendor;
    private String model;

    public String getVendor() {
        return vendor;
    }

    public Car(String vendor, String model) {
        this.vendor = vendor;
        this.model = model;
    }

    public void setVendor(String vendor) {

        this.vendor = vendor;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
