package com.movie_reservation_system.domain.repository;

import com.movie_reservation_system.domain.dto.CreateMovieRequest;
import com.movie_reservation_system.domain.dto.Movie;
import com.movie_reservation_system.domain.dto.MovieShowTimes;
import com.movie_reservation_system.domain.dto.UpdateMovieRequest;
import org.springframework.data.domain.Page;

public interface MovieRepository {
    Page<Movie> all(int page, int elements);
    Movie findById(long id);
    Movie create(CreateMovieRequest request);
    Movie updateById(UpdateMovieRequest request, long id);
    boolean delete(long id);
    MovieShowTimes showTimes(long id);
}
