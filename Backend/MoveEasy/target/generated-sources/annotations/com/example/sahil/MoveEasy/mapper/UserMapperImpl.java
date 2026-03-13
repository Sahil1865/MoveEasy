package com.example.sahil.MoveEasy.mapper;

import com.example.sahil.MoveEasy.dto.UserResponseDTO;
import com.example.sahil.MoveEasy.model.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-27T21:59:43+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.17 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserResponseDTO toDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponseDTO userResponseDTO = new UserResponseDTO();

        userResponseDTO.setId( user.getId() );
        userResponseDTO.setName( user.getName() );
        userResponseDTO.setEmail( user.getEmail() );
        userResponseDTO.setContact( user.getContact() );
        userResponseDTO.setRole( user.getRole() );
        userResponseDTO.setEnabled( user.getEnabled() );
        userResponseDTO.setCreatedAt( user.getCreatedAt() );

        return userResponseDTO;
    }
}
