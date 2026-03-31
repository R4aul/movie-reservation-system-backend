package com.movie_reservation_system.web.exception;

public record Error(
        String type,
        String message
) {
}
