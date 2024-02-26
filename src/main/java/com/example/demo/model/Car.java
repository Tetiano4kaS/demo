package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.validation.constraints.NotBlank;

@Data
@Document
public class Car {
    @MongoId
    private String id;
    @NotBlank(message = "name can not be blank")
    private String model;
    private String producer;
    @Min(value = 60, message = "power can not be lower than 60")
    @Max(value = 1500, message = "power can not be higher than 1500")
    private Integer power;
    @Lob
    @Column(columnDefinition = "BLOB")
    private byte[] image;
}
