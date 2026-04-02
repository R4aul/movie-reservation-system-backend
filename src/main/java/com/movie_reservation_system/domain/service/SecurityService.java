package com.movie_reservation_system.domain.service;

import com.movie_reservation_system.domain.dto.AuthUser;
import com.movie_reservation_system.domain.repository.UserRepository;
import com.movie_reservation_system.persistence.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SecurityService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = this.userRepository.findByEmail(username)
                .orElseThrow(()-> new UsernameNotFoundException("User Auth Not Found"));

        return new AuthUser(user);
    }
}
