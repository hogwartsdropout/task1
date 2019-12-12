package com.example.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access= AccessLevel.PRIVATE, force=true)
@Entity
@Table(name = "client")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id", updatable = false, nullable = false)
    private long id;
    @Column(name="username",unique = true)
    private String username;
    private String f_name;
    private String l_name;
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFName(String FName) {
        this.f_name = FName;
    }

    public void setLName(String LName) {
        this.l_name = LName;
    }
}
