package com.example.demo.mapper;

import com.example.demo.dto.CarDto;
import com.example.demo.model.Car;

public class CarMapper {
    public static Car mapDtoToEntity(CarDto carDto){
        Car car=new Car();
        car.setId(carDto.getId());
        car.setPower(carDto.getPower());
        car.setModel(carDto.getModel());
        car.setProducer(carDto.getProducer());
        return car;
    }

    public static CarDto mapEntityToDto(Car car) {
       return CarDto.builder()
                .id(car.getId())
                .power(car.getPower())
                .producer(car.getProducer())
                .model(car.getModel())
                .build();
    }
}
