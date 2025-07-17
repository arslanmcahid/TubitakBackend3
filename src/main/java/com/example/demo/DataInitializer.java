package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Set;

@Configuration
@RequiredArgsConstructor
public class DataInitializer {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Bean
    public CommandLineRunner initUsers() {
        return args -> {
            Authority adminRole = new Authority();
            adminRole.setAuthority("ROLE_ADMIN");

            Authority userRole = new Authority();
            userRole.setAuthority("ROLE_USER");

            Users admin = new Users();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin"));
            admin.setAuthorities(Set.of(adminRole));

            Users user = new Users();
            user.setUsername("user");
            user.setPassword(passwordEncoder.encode("user"));
            user.setAuthorities(Set.of(userRole));

            userRepository.saveAll(List.of(admin, user));
        };
    }
}
