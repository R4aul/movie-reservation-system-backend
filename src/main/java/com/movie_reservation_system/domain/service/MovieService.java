package com.movie_reservation_system.domain.service;

import com.movie_reservation_system.domain.dto.CreateMovieRequest;
import com.movie_reservation_system.domain.dto.Movie;
import com.movie_reservation_system.domain.dto.UpdateMovieRequest;
import com.movie_reservation_system.domain.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public Page<Movie> getAll(int page, int elements){
        return this.movieRepository.all(page, elements);
    }

    public Movie create(CreateMovieRequest request){
        return this.movieRepository.create(request);
    }

    public Movie getById(int id){
        return this.movieRepository.findById(id);
    }

    @Transactional
    public Movie update(UpdateMovieRequest request, int id){
        return this.movieRepository.updateById(request, id);
    }

    public boolean delete(int id){
        return this.movieRepository.delete(id);
    }
}
