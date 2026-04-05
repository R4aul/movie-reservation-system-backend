package com.movie_reservation_system.web.controller;

import com.movie_reservation_system.domain.dto.*;
import com.movie_reservation_system.domain.service.AuthService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest request){
        return ResponseEntity.ok(this.authService.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody @Valid RegisterRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.authService.register(request));
    }

    @GetMapping("/me")
    public ResponseEntity<MeResponse> me(@AuthenticationPrincipal AuthUser authUser){
        MeResponse meResponse = new MeResponse(authUser.getName(), authUser.getUsername());
        return ResponseEntity.ok(meResponse);
    }
}
