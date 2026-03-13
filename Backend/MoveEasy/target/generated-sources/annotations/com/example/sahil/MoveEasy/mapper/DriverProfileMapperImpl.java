package com.example.sahil.MoveEasy.mapper;

import com.example.sahil.MoveEasy.dto.DriverProfileResponseDTO;
import com.example.sahil.MoveEasy.model.DriverProfile;
import com.example.sahil.MoveEasy.model.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-27T21:59:43+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.17 (Eclipse Adoptium)"
)
@Component
public class DriverProfileMapperImpl implements DriverProfileMapper {

    @Override
    public DriverProfileResponseDTO toDTO(DriverProfile profile) {
        if ( profile == null ) {
            return null;
        }

        DriverProfileResponseDTO driverProfileResponseDTO = new DriverProfileResponseDTO();

        driverProfileResponseDTO.setUserId( profileUserId( profile ) );
        driverProfileResponseDTO.setId( profile.getId() );
        driverProfileResponseDTO.setLicenseNumber( profile.getLicenseNumber() );
        driverProfileResponseDTO.setVehicleNumber( profile.getVehicleNumber() );
        driverProfileResponseDTO.setVehicleModel( profile.getVehicleModel() );
        driverProfileResponseDTO.setRating( profile.getRating() );
        driverProfileResponseDTO.setTotalRides( profile.getTotalRides() );
        driverProfileResponseDTO.setAvailable( profile.getAvailable() );

        return driverProfileResponseDTO;
    }

    private Long profileUserId(DriverProfile driverProfile) {
        if ( driverProfile == null ) {
            return null;
        }
        User user = driverProfile.getUser();
        if ( user == null ) {
            return null;
        }
        Long id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
