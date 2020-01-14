package com.example.dao;


import com.example.entity.Car;
import com.example.entity.Customer;
import com.example.entity.Order;

public interface ITestDao {
  public void saveCustomer(Customer customer);
  public void saveCar(Car car);
  public void saveOrder(Order order);
}
