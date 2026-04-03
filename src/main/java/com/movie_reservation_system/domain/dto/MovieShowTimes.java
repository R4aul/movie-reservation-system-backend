package com.movie_reservation_system.domain.dto;

import java.util.List;

public record MovieShowTimes(
        Long id,
        String title,
        Integer duration,
        String rating,
        Genre genre,
        List<ShowTime> showtimes
) {
}
