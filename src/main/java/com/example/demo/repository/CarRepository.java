package com.example.demo.repository;

import com.example.demo.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CarRepository extends JpaRepository<Car, Integer> {
    List<Car> getCarByPower(Integer power);
    List<Car> getCarByProducer(String producer);
}
