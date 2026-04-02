package com.movie_reservation_system.domain.repository;

import com.movie_reservation_system.persistence.entity.RoleEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface RoleListCrudRepository extends ListCrudRepository<RoleEntity, Integer> {
    Optional<RoleEntity> findByName(String name);
}
