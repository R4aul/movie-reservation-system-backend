package com.movie_reservation_system.domain.repository;

import com.movie_reservation_system.domain.dto.Room;
import com.movie_reservation_system.domain.dto.RoomWithSeatDTO;

import java.util.List;

public interface RoomRepository {
    List<Room> getAll();
    Room getById(int id);
    RoomWithSeatDTO getWithSeats(int id);
}
