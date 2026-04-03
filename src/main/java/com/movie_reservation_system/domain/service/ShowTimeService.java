package com.movie_reservation_system.domain.service;

import com.movie_reservation_system.domain.dto.CreateShowTimeRequest;
import com.movie_reservation_system.domain.dto.ShowTime;
import com.movie_reservation_system.domain.repository.ShowTimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ShowTimeService {

    private final ShowTimeRepository repository;

    public Page<ShowTime> all(int page, int elements, Integer roomId, Long movieId, LocalDate date){
        return this.repository.getAll(page, elements, roomId, movieId, date);
    }

    public ShowTime get(long id){
        return this.repository.getById(id);
    }

    public ShowTime create(CreateShowTimeRequest request){
        return this.repository.create(request);
    }
}
