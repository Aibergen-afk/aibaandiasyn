package com.example.Finall.controller;

import com.example.Finall.model.User;
import com.example.Finall.service.MyUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class MyUserController {

    private final MyUserService myUserService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        myUserService.register(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/items")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<?> items() {
        return ResponseEntity.ok("You are authorized!");
    }
}
