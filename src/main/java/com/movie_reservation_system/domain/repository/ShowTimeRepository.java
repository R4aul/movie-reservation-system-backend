package com.movie_reservation_system.domain.repository;

import com.movie_reservation_system.domain.dto.CreateShowTimeRequest;
import com.movie_reservation_system.domain.dto.ShowTime;
import org.springframework.data.domain.Page;

import java.time.LocalDate;

public interface ShowTimeRepository {
    Page<ShowTime> getAll(int page, int elements, Integer roomId, Long movieId, LocalDate date);
    ShowTime getById(Long id);
    ShowTime create(CreateShowTimeRequest request);
}
