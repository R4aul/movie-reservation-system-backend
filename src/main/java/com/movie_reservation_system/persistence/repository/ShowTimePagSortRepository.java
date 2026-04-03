package com.movie_reservation_system.persistence.repository;

import com.movie_reservation_system.persistence.entity.MovieEntity;
import com.movie_reservation_system.persistence.entity.RoomEntity;
import com.movie_reservation_system.persistence.entity.ShowtimeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDateTime;

public interface ShowTimePagSortRepository extends PagingAndSortingRepository<ShowtimeEntity, Long> {

    //filter for room y movie
    Page<ShowtimeEntity> findByRoomAndMovie(
            RoomEntity room,
            MovieEntity movie,
            Pageable pageable
    );

    Page<ShowtimeEntity> findByRoomAndMovieAndStartTimeBetween(
            RoomEntity room,
            MovieEntity movie,
            LocalDateTime start,
            LocalDateTime end,
            Pageable pageable
    );

    Page<ShowtimeEntity> findByRoomAndStartTimeBetween(RoomEntity room, LocalDateTime start, LocalDateTime end,Pageable pageable);

    Page<ShowtimeEntity> findByMovieAndStartTimeBetween(MovieEntity movie, LocalDateTime start, LocalDateTime end,Pageable pageable);

    Page<ShowtimeEntity> findByRoom(RoomEntity room, Pageable pageable);

    Page<ShowtimeEntity> findByMovie(MovieEntity movie, Pageable pageable);
}
