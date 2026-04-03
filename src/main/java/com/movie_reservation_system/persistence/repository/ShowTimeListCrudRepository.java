package com.movie_reservation_system.persistence.repository;

import com.movie_reservation_system.persistence.entity.ShowtimeEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ShowTimeListCrudRepository extends ListCrudRepository<ShowtimeEntity, Long> {
}
