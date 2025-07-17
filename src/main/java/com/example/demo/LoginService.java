package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final CustomAuthenticationProvider authenticationProvider;

    public String login(LoginRequestDto request){
        try {
            UsernamePasswordAuthenticationToken authToken =
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());

            Authentication authentication = authenticationProvider.authenticate(authToken);

            if (authentication.isAuthenticated()) {
                return "Giriş başarılı: " + authentication.getName();
            } else {
                return "Giriş başarısız";
            }

        } catch (AuthenticationException e) {
            return "Hata: " + e.getMessage();
        }
    }
}
