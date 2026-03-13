package com.example.sahil.MoveEasy.model;

import com.example.sahil.MoveEasy.enums.AuthProvider;
import com.example.sahil.MoveEasy.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Table(name = "users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @Email
    @Column(unique = true)
    private String email;

    private String contact;

    private String passwordHash;

    @Enumerated(EnumType.STRING)
    private Role role=Role.USER;

    private Boolean enabled= true;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AuthProvider primaryProvider;

    private String providerId; // Google "sub"

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
}
