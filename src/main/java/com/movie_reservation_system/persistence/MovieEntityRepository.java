package com.movie_reservation_system.persistence;

import com.movie_reservation_system.domain.dto.CreateMovieRequest;
import com.movie_reservation_system.domain.dto.Movie;
import com.movie_reservation_system.domain.dto.UpdateMovieRequest;
import com.movie_reservation_system.domain.exception.NotFoundException;
import com.movie_reservation_system.domain.repository.MovieRepository;
import com.movie_reservation_system.persistence.entity.GenreEntity;
import com.movie_reservation_system.persistence.entity.MovieEntity;
import com.movie_reservation_system.persistence.mapper.MovieMapper;
import com.movie_reservation_system.persistence.repository.GenreListCrudRepository;
import com.movie_reservation_system.persistence.repository.MovieListCrudRepository;
import com.movie_reservation_system.persistence.repository.MoviePagSortRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MovieEntityRepository implements MovieRepository {

    private final MovieListCrudRepository listCrudRepository;
    private final MoviePagSortRepository pagSortRepository;
    private final MovieMapper mapper;
    private final GenreListCrudRepository genreListCrudRepository;

    @Override
    public Page<Movie> all(int page, int elements) {
        Pageable pageable = PageRequest.of(page, elements);
        Page<MovieEntity> movies = this.pagSortRepository.findAll(pageable);
        return movies.map(this.mapper::toDTO);
    }

    @Override
    public Movie findById(long id) {
        MovieEntity movieEntity = this.listCrudRepository.findById(id)
                        .orElseThrow(() -> new NotFoundException("Movie Not Found"));
        return this.mapper.toDTO(movieEntity);
    }

    @Override
    public Movie create(CreateMovieRequest request) {
        GenreEntity genre = this.genreListCrudRepository.findById(request.genreId())
                .orElseThrow(()-> new NotFoundException("Genre Not Found"));

        MovieEntity movie = MovieEntity.builder()
                .title(request.title())
                .duration(request.duration())
                .rating(request.rating())
                .genre(genre)
                .build();

        MovieEntity movieEntity = this.listCrudRepository.save(movie);
        return this.mapper.toDTO(movieEntity);
    }

    @Override
    public Movie updateById(UpdateMovieRequest request, long id) {
        MovieEntity entity = this.listCrudRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Movie Not Found"));

        GenreEntity genreEntity = this.genreListCrudRepository.findById(request.getGenreId())
                .orElseThrow(() -> new NotFoundException("Genre Not Found"));

        MovieEntity movie = MovieEntity.builder()
                .title(request.getTitle())
                .duration(request.getDuration())
                .rating(request.getRating())
                .genre(genreEntity)
                .build();
        return this.mapper.toDTO(this.listCrudRepository.save(movie));
    }

    @Override
    public boolean delete(long id) {
        if (!this.listCrudRepository.existsById(id)) {
            throw new NotFoundException("Movie Not Found");
        }
        this.listCrudRepository.deleteById(id);
        return true;
    }
}
