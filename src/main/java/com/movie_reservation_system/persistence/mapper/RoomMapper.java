package com.movie_reservation_system.persistence.mapper;

import com.movie_reservation_system.domain.dto.Room;
import com.movie_reservation_system.domain.dto.RoomWithSeatDTO;
import com.movie_reservation_system.persistence.entity.RoomEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {
    SeatMapper.class
})
public interface RoomMapper {
    List<Room> toDTOs(List<RoomEntity> entity);
    Room toDTO(RoomEntity entity);
    RoomWithSeatDTO toDtoWithSeat(RoomEntity entity);
}
