package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RoleTestController {

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
    @GetMapping("/user")
    public String user() {
        return "user veya admin girdi";
    }

}
