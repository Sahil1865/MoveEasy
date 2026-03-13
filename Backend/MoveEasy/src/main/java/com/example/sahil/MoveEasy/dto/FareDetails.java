package com.example.sahil.MoveEasy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FareDetails {

    private Double distanceKm;
    private Integer durationMinutes;
    private Double baseFare;
    private Double surgeMultiplier;
    private Double finalFare;
}