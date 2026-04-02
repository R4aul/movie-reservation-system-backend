package com.movie_reservation_system.domain.repository;

import com.movie_reservation_system.persistence.entity.UserEntity;

import java.util.Optional;

public interface UserRepository {
    Optional<UserEntity> findByEmail(String email);
}
