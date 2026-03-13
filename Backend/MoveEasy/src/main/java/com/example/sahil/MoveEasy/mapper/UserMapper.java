package com.example.sahil.MoveEasy.mapper;

import com.example.sahil.MoveEasy.dto.RegisterRequestDTO;
import com.example.sahil.MoveEasy.dto.UserResponseDTO;
import com.example.sahil.MoveEasy.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "passwordHash", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    static User toEntity(RegisterRequestDTO dto) {
        return null;
    }

    UserResponseDTO toDTO(User user);
}
