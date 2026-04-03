package com.movie_reservation_system.persistence.mapper;

import com.movie_reservation_system.domain.dto.ShowTime;
import com.movie_reservation_system.persistence.entity.ShowtimeEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {
        MovieMapper.class,
        RoomMapper.class
})
public interface ShowTimeMapper{
    ShowTime toDTO(ShowtimeEntity entity);
}
