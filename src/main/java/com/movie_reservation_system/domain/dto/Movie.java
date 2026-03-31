package com.movie_reservation_system.domain.dto;

import lombok.Data;

@Data
public class Movie {
    private Long id;
    private String title;
    private Integer duration;
    private String rating;
    private Genre genre;
}
