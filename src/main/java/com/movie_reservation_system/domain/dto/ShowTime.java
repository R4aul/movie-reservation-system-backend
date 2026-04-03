package com.movie_reservation_system.domain.dto;

import java.time.LocalDateTime;

public record ShowTime(
        LocalDateTime startTime,
        Movie movie,
        Room room
) {
}
