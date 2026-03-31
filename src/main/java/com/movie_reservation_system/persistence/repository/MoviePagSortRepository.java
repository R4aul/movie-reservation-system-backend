package com.movie_reservation_system.persistence.repository;

import com.movie_reservation_system.persistence.entity.MovieEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MoviePagSortRepository extends PagingAndSortingRepository<MovieEntity, Long> {
}
