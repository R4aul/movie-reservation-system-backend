package com.movie_reservation_system.persistence.repository;

import com.movie_reservation_system.persistence.entity.RoomEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface RoomListCrudRepository extends ListCrudRepository<RoomEntity, Integer> {

}
