package com.movie_reservation_system.domain.service;

import com.movie_reservation_system.domain.dto.*;
import com.movie_reservation_system.domain.repository.RegisterUserRepository;
import com.movie_reservation_system.web.utils.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final RegisterUserRepository registerUserRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public LoginResponse login(LoginRequest request){
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                request.email(),
                request.password()
        );

        Authentication authentication = this.authenticationManager.authenticate(authenticationToken);
        String jwt = this.jwtUtil.create(request.email());
        return new LoginResponse(jwt);
    }

    public RegisterResponse register(RegisterRequest request){
        request.setPassword(passwordEncoder.encode(request.getPassword()));
        User user = this.registerUserRepository.register(request);
        String jwt = this.jwtUtil.create(user.email());
        return new RegisterResponse(jwt);
    }

}
