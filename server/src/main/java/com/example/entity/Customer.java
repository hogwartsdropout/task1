package com.example.entity;

import lombok.*;

import javax.persistence.*;

@Data
//@RequiredArgsConstructor
//@NoArgsConstructor(access= AccessLevel.PRIVATE, force=true)
//@ToString
@Entity
@Table(name = "client")
public class Customer {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id", updatable = false, nullable = false)
    private Long id;
    @Column(name="username",unique = true)
    private String username;
    private String f_name;
    private String l_name;
    private String password;

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getF_name() {
        return f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public String getPassword() {
        return password;
    }



    public void setUsername(String username) {
        this.username = username;
    }

    public void setFName(String FName) {
        this.f_name = FName;
    }

    public void setLName(String LName) {
        this.l_name = LName;
    }
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", f_name='" + f_name + '\'' +
                ", l_name='" + l_name + '\'' +
                '}';
    }

    public Customer(String username, String f_name, String l_name, String password) {
        this.username = username;
        this.f_name = f_name;
        this.l_name = l_name;
        this.password = password;
    }
    public Customer(){
    }
}
