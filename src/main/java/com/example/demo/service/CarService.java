package com.example.demo.service;

import com.example.demo.dto.CarDto;
import com.example.demo.exception.CarNotFoundException;
import com.example.demo.mapper.CarMapper;
import com.example.demo.model.Car;
import com.example.demo.repository.CarRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final EmailService emailService;


    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public CarDto getCarById(Integer id) {
        Car car = carRepository.findById(id).orElseThrow(()
                -> new CarNotFoundException("Car with id: " + id + " Not Found"));
        CarDto carDto = CarMapper.mapEntityToDto(car);
        return carDto;
    }

    public Car createCar(CarDto carDto) {
        Car car = CarMapper.mapDtoToEntity(carDto);
        Car savedCar = carRepository.save(car);
        emailService.sendMail("New car created", "Car %s was created with power %s".formatted(carDto.getModel(), carDto.getPower()));
        return savedCar;
    }

    public void deleteCar(Integer id) {
        carRepository.deleteById(id);
        emailService.sendMail("Car was delete", "Car with id: " + id + " was delete");
    }

    public List<Car> getCarsByPower(Integer power) {
        return carRepository.getCarByPower(power);
    }

    public List<Car> getCarsByProducer(String producer) {
        return carRepository.getCarByProducer(producer);
    }

    @Transactional
    public void updateCarImage(Integer id, byte[] image) {
        carRepository
                .findById(id)
                .ifPresent(car -> car.setImage(image));

    }
}
