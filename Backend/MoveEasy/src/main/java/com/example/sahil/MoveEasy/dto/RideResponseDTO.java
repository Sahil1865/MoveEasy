package com.example.sahil.MoveEasy.dto;

import com.example.sahil.MoveEasy.enums.RideStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class RideResponseDTO {

    private Long id;

    private LocationDTO pickupLocation;
    private LocationDTO dropLocation;

    private Double distanceKm;
    private Integer estimatedDurationMinutes;

    private Double baseFare;
    private Double surgeMultiplier;
    private Double finalFare;

    private RideStatus status;

    private Long riderId;
    private Long driverId;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
}