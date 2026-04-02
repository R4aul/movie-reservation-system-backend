package com.movie_reservation_system.persistence.mapper;

import com.movie_reservation_system.domain.dto.Seat;
import com.movie_reservation_system.persistence.entity.SeatEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SeatMapper {
    List<Seat> toDTOs(List<SeatEntity> entities);
}
