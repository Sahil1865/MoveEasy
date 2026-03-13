package com.example.sahil.MoveEasy.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DriverProfileResponseDTO {

    private Long id;
    private String licenseNumber;
    private String vehicleNumber;
    private String vehicleModel;

    private Double rating;
    private Integer totalRides;
    private Boolean available;

    private Long userId;
}