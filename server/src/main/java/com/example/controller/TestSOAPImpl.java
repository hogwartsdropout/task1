package com.example.controller;

import com.example.entity.Car;

public class TestSOAPImpl implements TestSOAPInterface {
    @Override
    public Car getCarById(Long id) {
        return new Car("test", "test");
    }
}
