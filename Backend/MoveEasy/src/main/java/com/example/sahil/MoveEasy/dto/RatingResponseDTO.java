package com.example.sahil.MoveEasy.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class RatingResponseDTO {

    private Long id;
    private Integer stars;
    private String comment;
    private LocalDateTime createdAt;

    private Long rideId;
    private Long riderId;
    private Long driverId;
}