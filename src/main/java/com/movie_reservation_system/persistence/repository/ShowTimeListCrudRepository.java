package com.movie_reservation_system.persistence.repository;

import com.movie_reservation_system.persistence.entity.MovieEntity;
import com.movie_reservation_system.persistence.entity.ShowtimeEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ShowTimeListCrudRepository extends ListCrudRepository<ShowtimeEntity, Long> {
    List<ShowtimeEntity> findByMovieAndStartTimeAfter(MovieEntity movie, LocalDateTime now);
}
