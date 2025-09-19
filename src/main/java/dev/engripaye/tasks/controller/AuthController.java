package dev.engripaye.tasks.controller;

import dev.engripaye.tasks.dtos.AuthRequest;
import dev.engripaye.tasks.dtos.AuthResponse;
import dev.engripaye.tasks.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Validated @RequestBody AuthRequest authRequest){
        AuthResponse response = authService.register(authRequest);
        return ResponseEntity.ok(response);

    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Validated @RequestBody AuthRequest authRequest){
        AuthResponse response = authService.login(authRequest);
        return ResponseEntity.ok(response);
    }
}
