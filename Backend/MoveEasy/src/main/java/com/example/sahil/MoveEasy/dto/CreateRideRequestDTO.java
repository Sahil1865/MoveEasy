package com.example.sahil.MoveEasy.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateRideRequestDTO {

    @NotNull
    private LocationDTO pickupLocation;

    @NotNull
    private LocationDTO dropLocation;
}