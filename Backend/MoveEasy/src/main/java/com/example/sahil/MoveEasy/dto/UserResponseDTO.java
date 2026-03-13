package com.example.sahil.MoveEasy.dto;

import com.example.sahil.MoveEasy.enums.Role;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String contact;
    private Role role;
    private Boolean enabled;
    private LocalDateTime createdAt;

}