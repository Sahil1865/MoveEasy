package com.example.sahil.MoveEasy.mapper;

import com.example.sahil.MoveEasy.dto.LocationDTO;
import com.example.sahil.MoveEasy.model.Location;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocationMapper {

    LocationDTO toDTO(Location location);

    Location toEntity(LocationDTO dto);
}