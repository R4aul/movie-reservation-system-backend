package com.movie_reservation_system.domain.dto;

public record Seat(
        Long id,
        String seatRow,
        Integer seatNumber
) {
}
