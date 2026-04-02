package com.movie_reservation_system.domain.dto;

import java.util.List;

public record RoomWithSeatDTO(
        String name,
        Integer capacity,
        List<Seat> seats
) {
}
