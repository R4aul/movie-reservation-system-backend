package com.movie_reservation_system.persistence.repository;

import com.movie_reservation_system.persistence.entity.MovieEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface MovieListCrudRepository extends ListCrudRepository<MovieEntity, Long> {
}
