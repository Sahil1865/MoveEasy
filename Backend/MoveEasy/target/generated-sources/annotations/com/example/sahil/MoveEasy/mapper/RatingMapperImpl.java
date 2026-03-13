package com.example.sahil.MoveEasy.mapper;

import com.example.sahil.MoveEasy.dto.RatingResponseDTO;
import com.example.sahil.MoveEasy.model.Rating;
import com.example.sahil.MoveEasy.model.Ride;
import com.example.sahil.MoveEasy.model.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-27T21:59:43+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.17 (Eclipse Adoptium)"
)
@Component
public class RatingMapperImpl implements RatingMapper {

    @Override
    public RatingResponseDTO toDTO(Rating rating) {
        if ( rating == null ) {
            return null;
        }

        RatingResponseDTO ratingResponseDTO = new RatingResponseDTO();

        ratingResponseDTO.setRideId( ratingRideId( rating ) );
        ratingResponseDTO.setRiderId( ratingRiderId( rating ) );
        ratingResponseDTO.setDriverId( ratingDriverId( rating ) );
        ratingResponseDTO.setId( rating.getId() );
        ratingResponseDTO.setStars( rating.getStars() );
        ratingResponseDTO.setComment( rating.getComment() );
        ratingResponseDTO.setCreatedAt( rating.getCreatedAt() );

        return ratingResponseDTO;
    }

    private Long ratingRideId(Rating rating) {
        if ( rating == null ) {
            return null;
        }
        Ride ride = rating.getRide();
        if ( ride == null ) {
            return null;
        }
        Long id = ride.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long ratingRiderId(Rating rating) {
        if ( rating == null ) {
            return null;
        }
        User rider = rating.getRider();
        if ( rider == null ) {
            return null;
        }
        Long id = rider.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long ratingDriverId(Rating rating) {
        if ( rating == null ) {
            return null;
        }
        User driver = rating.getDriver();
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
