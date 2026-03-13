package com.example.sahil.MoveEasy.mapper;

import com.example.sahil.MoveEasy.dto.LocationDTO;
import com.example.sahil.MoveEasy.model.Location;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-27T21:59:43+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.17 (Eclipse Adoptium)"
)
@Component
public class LocationMapperImpl implements LocationMapper {

    @Override
    public LocationDTO toDTO(Location location) {
        if ( location == null ) {
            return null;
        }

        LocationDTO locationDTO = new LocationDTO();

        locationDTO.setLatitude( location.getLatitude() );
        locationDTO.setLongitude( location.getLongitude() );
        locationDTO.setAddress( location.getAddress() );

        return locationDTO;
    }

    @Override
    public Location toEntity(LocationDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Location location = new Location();

        location.setLatitude( dto.getLatitude() );
        location.setLongitude( dto.getLongitude() );
        location.setAddress( dto.getAddress() );

        return location;
    }
}
