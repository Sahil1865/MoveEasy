package com.example.sahil.MoveEasy.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class DriverProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String licenseNumber;
    private String vehicleNumber;
    private String vehicleModel;

    private Double rating = 0.0;
    private Integer totalRides = 0;

    private Boolean available = true;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
