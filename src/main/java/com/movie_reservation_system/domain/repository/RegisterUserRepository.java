package com.movie_reservation_system.domain.repository;

import com.movie_reservation_system.domain.dto.RegisterRequest;
import com.movie_reservation_system.domain.dto.User;

public interface RegisterUserRepository {
    User register(RegisterRequest request);
}
