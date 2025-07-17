package com.example.demo;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

@Entity
@Data
public class Authority implements GrantedAuthority {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany(mappedBy = "authorities")
    private Set<Users> users;
    private String authority;

}
