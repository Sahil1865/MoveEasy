package com.example.sahil.MoveEasy.mapper;

import com.example.sahil.MoveEasy.dto.RideResponseDTO;
import com.example.sahil.MoveEasy.model.Ride;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {LocationMapper.class})
public interface RideMapper {

    @Mapping(source = "rider.id", target = "riderId")
    @Mapping(source = "driver.id", target = "driverId")
    RideResponseDTO toDTO(Ride ride);
}