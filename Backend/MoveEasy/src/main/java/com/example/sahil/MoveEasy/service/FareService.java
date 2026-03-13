package com.example.sahil.MoveEasy.service;

import com.example.sahil.MoveEasy.dto.FareDetails;
import org.springframework.stereotype.Service;

@Service
public class FareService {

    private static final double BASE_RATE_PER_KM = 10;
    private static final double BASE_FARE = 30;

    public FareDetails calculateFare(double distanceKm, int durationMinutes) {

        double baseFare = BASE_FARE + (distanceKm * BASE_RATE_PER_KM);

        double surgeMultiplier = 1.0; // later dynamic

        double finalFare = baseFare * surgeMultiplier;

        return new FareDetails(distanceKm, durationMinutes, baseFare, surgeMultiplier, finalFare);
    }
}