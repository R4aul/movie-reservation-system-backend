package com.movie_reservation_system.persistence.mapper;

import com.movie_reservation_system.domain.dto.Genre;
import com.movie_reservation_system.persistence.entity.GenreEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GenreMapper {
    Genre toDTO(GenreEntity entity);
}
