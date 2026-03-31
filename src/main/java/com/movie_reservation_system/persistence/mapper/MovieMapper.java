package com.movie_reservation_system.persistence.mapper;

import com.movie_reservation_system.domain.dto.CreateMovieRequest;
import com.movie_reservation_system.domain.dto.Movie;
import com.movie_reservation_system.persistence.entity.MovieEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {
        GenreMapper.class
})
public interface MovieMapper {

    Movie toDTO(MovieEntity entity);

    MovieEntity toEntity(CreateMovieRequest request);
}
