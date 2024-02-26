package com.example.demo.controller;

import com.example.demo.dto.CarDto;
import com.example.demo.model.Car;
import com.example.demo.service.CarService;
import com.example.demo.util.View;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;


    @GetMapping()
    public ResponseEntity<List<Car>> getCars() {
        List<Car> allCars = carService.getAllCars();
        return ResponseEntity.ok(allCars);
    }

    @JsonView(View.Level2.class)
    @GetMapping("/{id}")
    public ResponseEntity<CarDto> getCar(@PathVariable String id) {
        CarDto carDtoById = carService.getCarById(id);
        return ResponseEntity.ok(carDtoById);
    }

    @PostMapping()
    public ResponseEntity<Car> createCar(@RequestBody CarDto carDto) {
        Car car = carService.createCar(carDto);
        return new ResponseEntity(car, HttpStatus.CREATED);
    }

//    @SneakyThrows
//    @PutMapping("/{id}/image")
//    public ResponseEntity<Void> uploadCarImage(@PathVariable Integer id, @RequestParam("file") MultipartFile attachment) {
//        carService.updateCarImage(id, attachment.getBytes());
//        return new ResponseEntity(HttpStatus.OK);
//    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCar(@PathVariable String id) {
        carService.deleteCar(id);
    }

    @GetMapping("/power/{power}")
    @ResponseStatus(HttpStatus.OK)
    public List<Car> getByPower(@PathVariable Integer power) {
        List<Car> carsByPower = carService.getCarsByPower(power);
        return carsByPower;
    }

    @GetMapping("/producer/{producer}")
    @ResponseStatus(HttpStatus.OK)
    public List<Car> getByProducer(@PathVariable String producer) {
        List<Car> carsByProducer = carService.getCarsByProducer(producer);
        return carsByProducer;
    }

}
