package com.example.demo.dto;

import com.example.demo.util.View;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarDto {
    @JsonView(View.Level1.class)
    private Integer id;
    @JsonView(View.Level2.class)
    private String model;
    @JsonView(View.Level1.class)
    private String producer;
    @JsonView(View.Level2.class)
    private Integer power;

}
