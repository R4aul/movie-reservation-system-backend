package com.movie_reservation_system.persistence.repository;

import com.movie_reservation_system.persistence.entity.GenreEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface GenreListCrudRepository extends ListCrudRepository<GenreEntity, Integer> {
}
