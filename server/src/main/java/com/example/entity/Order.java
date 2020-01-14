package com.example.entity;

import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;
import org.hibernate.HibernateException;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.engine.spi.SharedSessionContractImplementor;

import javax.persistence.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

@Entity
@Table(name = "\"order\"")
@TypeDef(name="pgsql_enum", typeClass = PostgreSQLEnumType.class)
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
    @Enumerated(EnumType.STRING)
    @Type( type = "pgsql_enum" )
    private Status status;

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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Order(long client, long car, String color, Status status) {
        this.client = client;
        this.car = car;
        this.color = color;
        this.status = status;
    }
    public Order(){}

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
    public enum Status {
        CREATED,PROGRESS,DONE
    }

}
