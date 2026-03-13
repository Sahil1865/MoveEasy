package com.example.sahil.MoveEasy.mapper;

import com.example.sahil.MoveEasy.dto.DriverProfileResponseDTO;
import com.example.sahil.MoveEasy.model.DriverProfile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DriverProfileMapper {

    @Mapping(source = "user.id", target = "userId")
    DriverProfileResponseDTO toDTO(DriverProfile profile);
}