package com.example.sahil.MoveEasy.controller;

import com.example.sahil.MoveEasy.dto.AuthResponseDTO;
import com.example.sahil.MoveEasy.dto.LoginRequestDTO;
import com.example.sahil.MoveEasy.dto.RegisterRequestDTO;
import com.example.sahil.MoveEasy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponseDTO> register(
            @RequestBody RegisterRequestDTO request) {

        return ResponseEntity.ok(userService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(
            @RequestBody LoginRequestDTO request) {

        return ResponseEntity.ok(userService.login(request));
    }
}