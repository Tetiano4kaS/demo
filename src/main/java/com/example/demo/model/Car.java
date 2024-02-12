package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
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
