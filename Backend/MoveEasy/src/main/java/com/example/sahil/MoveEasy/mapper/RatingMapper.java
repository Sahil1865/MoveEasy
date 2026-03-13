package com.example.sahil.MoveEasy.mapper;

import com.example.sahil.MoveEasy.dto.RatingResponseDTO;
import com.example.sahil.MoveEasy.model.Rating;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RatingMapper {
    @Mapping(source = "ride.id", target = "rideId")
    @Mapping(source = "rider.id", target = "riderId")
    @Mapping(source = "driver.id", target = "driverId")
    RatingResponseDTO toDTO(Rating rating);
}