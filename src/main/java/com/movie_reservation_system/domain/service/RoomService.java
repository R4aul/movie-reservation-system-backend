package com.movie_reservation_system.domain.service;

import com.movie_reservation_system.domain.dto.Room;
import com.movie_reservation_system.domain.dto.RoomWithSeatDTO;
import com.movie_reservation_system.domain.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoomService {

    private final RoomRepository repository;

    public List<Room> all(){
        return this.repository.getAll();
    }

    public Room getById(int id){
        return this.repository.getById(id);
    }

    public RoomWithSeatDTO getRoomWithSeats(int id){
        return repository.getWithSeats(id);
    }
}
