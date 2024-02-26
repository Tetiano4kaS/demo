package com.example.demo.repository;

import com.example.demo.model.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface CarRepository extends MongoRepository<Car, String> {
    List<Car> getCarByPower(Integer power);
    List<Car> getCarByProducer(String producer);
}
