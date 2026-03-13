package com.example.sahil.MoveEasy.service;

import com.example.sahil.MoveEasy.dto.AuthResponseDTO;
import com.example.sahil.MoveEasy.dto.LoginRequestDTO;
import com.example.sahil.MoveEasy.dto.RegisterRequestDTO;
import com.example.sahil.MoveEasy.dto.UserResponseDTO;
import com.example.sahil.MoveEasy.enums.Role;
import com.example.sahil.MoveEasy.mapper.UserMapper;
import com.example.sahil.MoveEasy.model.User;
import com.example.sahil.MoveEasy.repository.UserRepository;
import com.example.sahil.MoveEasy.security.JwtUtil;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public AuthResponseDTO register(RegisterRequestDTO request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        User user = UserMapper.toEntity(request);

        user.setPasswordHash(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.USER); // force safe role
        user.setEnabled(true);

        userRepository.save(user);

        String token = jwtUtil.generateToken(user.getEmail(), user.getRole().name());

        return new AuthResponseDTO(token);
    }

    public AuthResponseDTO login(LoginRequestDTO request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        User user = (User) userRepository.findByEmail(request.getEmail())
                .orElseThrow();

        String token = jwtUtil.generateToken(user.getEmail(), user.getRole().name());

        return new AuthResponseDTO(token);
    }
}