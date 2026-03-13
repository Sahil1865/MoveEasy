package com.example.sahil.MoveEasy.service;

import com.example.sahil.MoveEasy.enums.AuthProvider;
import com.example.sahil.MoveEasy.enums.Role;
import com.example.sahil.MoveEasy.model.User;
import com.example.sahil.MoveEasy.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OAuthService {

    private final UserRepository userRepository;

    public User processGoogleUser(OAuth2User oAuth2User) {

        String email = oAuth2User.getAttribute("email");
        String googleId = oAuth2User.getAttribute("sub");
        Boolean emailVerified = oAuth2User.getAttribute("email_verified");
        String name = oAuth2User.getAttribute("name");

        if (email == null || !Boolean.TRUE.equals(emailVerified)) {
            throw new RuntimeException("Email not verified");
        }

        User user = (User) userRepository.findByEmail(email).orElse(null);

        if (user == null) {
            user = new User();
            user.setEmail(email);
            user.setName(name);
            user.setPrimaryProvider(AuthProvider.GOOGLE);
            user.setProviderId(googleId);
            user.setRole(Role.USER);
            user.setEnabled(true);
            userRepository.save(user);
        } else if (user.getProviderId() == null) {
            user.setProviderId(googleId);
            userRepository.save(user);
        }

        return user;
    }
}