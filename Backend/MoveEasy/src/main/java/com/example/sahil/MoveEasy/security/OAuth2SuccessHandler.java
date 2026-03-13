package com.example.sahil.MoveEasy.security;

import com.example.sahil.MoveEasy.enums.AuthProvider;
import com.example.sahil.MoveEasy.enums.Role;
import com.example.sahil.MoveEasy.model.User;
import com.example.sahil.MoveEasy.repository.UserRepository;
import com.example.sahil.MoveEasy.service.OAuthService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class OAuth2SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication)
            throws IOException {

        OAuth2User oauthUser = (OAuth2User) authentication.getPrincipal();

        String email = oauthUser.getAttribute("email");
        String name = oauthUser.getAttribute("name");

        Optional<User> existingUser = userRepository.findByEmail(email);

        User user;

        if(existingUser.isPresent()){
            user = existingUser.get();
        } else {

            String role = getRoleFromCookie(request);

            user = new User();
            user.setEmail(email);
            user.setName(name);
            user.setRole(Role.valueOf(role));

            user.setPrimaryProvider(AuthProvider.GOOGLE);
            user.setProviderId(oauthUser.getAttribute("sub"));

            userRepository.save(user);
        }

        String token = jwtUtil.generateToken(user.getEmail(), user.getRole().name());

        String redirectUrl = "http://localhost:5173/oauth-success?token=" + token;

        getRedirectStrategy().sendRedirect(request,response,redirectUrl);
    }

    private String getRoleFromCookie(HttpServletRequest request) {
        if (request.getCookies() == null) return "USER";

        for (Cookie cookie : request.getCookies()) {
            if ("oauth_role".equals(cookie.getName())) {
                return cookie.getValue();
            }
        }

        return "USER";
    }
}