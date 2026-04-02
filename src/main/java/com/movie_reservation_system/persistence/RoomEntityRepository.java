package com.movie_reservation_system.persistence;

import com.movie_reservation_system.domain.dto.Room;
import com.movie_reservation_system.domain.dto.RoomWithSeatDTO;
import com.movie_reservation_system.domain.exception.NotFoundException;
import com.movie_reservation_system.domain.repository.RoomRepository;
import com.movie_reservation_system.persistence.entity.RoomEntity;
import com.movie_reservation_system.persistence.mapper.RoomMapper;
import com.movie_reservation_system.persistence.repository.RoomListCrudRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class RoomEntityRepository implements RoomRepository {

    private final RoomListCrudRepository repository;
    private final RoomMapper mapper;

    @Override
    public List<Room> getAll() {
        List<RoomEntity> roomEntities = this.repository.findAll();
        return mapper.toDTOs(roomEntities);
    }

    @Override
    public Room getById(int id) {
        RoomEntity roomEntity = repository.findById(id)
                .orElseThrow(()-> new NotFoundException("Room Not Found"));
        return mapper.toDTO(roomEntity);
    }

    @Override
    public RoomWithSeatDTO getWithSeats(int id) {
        RoomEntity roomEntity = repository.findById(id)
                .orElseThrow(()-> new NotFoundException("Room Not Found"));
        return mapper.toDtoWithSeat(roomEntity);
    }
}
