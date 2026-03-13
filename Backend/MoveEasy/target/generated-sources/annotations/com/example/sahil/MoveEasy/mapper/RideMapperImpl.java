package com.example.sahil.MoveEasy.mapper;

import com.example.sahil.MoveEasy.dto.RideResponseDTO;
import com.example.sahil.MoveEasy.model.Ride;
import com.example.sahil.MoveEasy.model.User;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-27T21:59:43+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.17 (Eclipse Adoptium)"
)
@Component
public class RideMapperImpl implements RideMapper {

    @Autowired
    private LocationMapper locationMapper;

    @Override
    public RideResponseDTO toDTO(Ride ride) {
        if ( ride == null ) {
            return null;
        }

        RideResponseDTO rideResponseDTO = new RideResponseDTO();

        rideResponseDTO.setRiderId( rideRiderId( ride ) );
        rideResponseDTO.setDriverId( rideDriverId( ride ) );
        rideResponseDTO.setId( ride.getId() );
        rideResponseDTO.setPickupLocation( locationMapper.toDTO( ride.getPickupLocation() ) );
        rideResponseDTO.setDropLocation( locationMapper.toDTO( ride.getDropLocation() ) );
        rideResponseDTO.setDistanceKm( ride.getDistanceKm() );
        rideResponseDTO.setEstimatedDurationMinutes( ride.getEstimatedDurationMinutes() );
        rideResponseDTO.setBaseFare( ride.getBaseFare() );
        rideResponseDTO.setSurgeMultiplier( ride.getSurgeMultiplier() );
        rideResponseDTO.setFinalFare( ride.getFinalFare() );
        rideResponseDTO.setStatus( ride.getStatus() );
        rideResponseDTO.setStartTime( ride.getStartTime() );
        rideResponseDTO.setEndTime( ride.getEndTime() );

        return rideResponseDTO;
    }

    private Long rideRiderId(Ride ride) {
        if ( ride == null ) {
            return null;
        }
        User rider = ride.getRider();
        if ( rider == null ) {
            return null;
        }
        Long id = rider.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long rideDriverId(Ride ride) {
        if ( ride == null ) {
            return null;
        }
        User driver = ride.getDriver();
        if ( driver == null ) {
            return null;
        }
        Long id = driver.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
