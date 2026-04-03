package com.movie_reservation_system.persistence;

import com.movie_reservation_system.domain.dto.CreateShowTimeRequest;
import com.movie_reservation_system.domain.dto.ShowTime;
import com.movie_reservation_system.domain.exception.NotFoundException;
import com.movie_reservation_system.domain.repository.ShowTimeRepository;
import com.movie_reservation_system.persistence.entity.MovieEntity;
import com.movie_reservation_system.persistence.entity.RoomEntity;
import com.movie_reservation_system.persistence.entity.ShowtimeEntity;
import com.movie_reservation_system.persistence.mapper.ShowTimeMapper;
import com.movie_reservation_system.persistence.repository.MovieListCrudRepository;
import com.movie_reservation_system.persistence.repository.RoomListCrudRepository;
import com.movie_reservation_system.persistence.repository.ShowTimeListCrudRepository;
import com.movie_reservation_system.persistence.repository.ShowTimePagSortRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Repository
@RequiredArgsConstructor
public class ShowTimeEntityRepository implements ShowTimeRepository {

    private final ShowTimePagSortRepository pagSortRepository;
    private final MovieListCrudRepository movieListCrudRepository;
    private final RoomListCrudRepository roomListCrudRepository;
    private final ShowTimeListCrudRepository showTimeListCrudRepository;
    private final ShowTimeMapper mapper;

    @Override
    public Page<ShowTime> getAll(int page, int elements, Integer roomId, Long movieId, LocalDate date) {
        Pageable pageable = PageRequest.of(page,elements);
        Page<ShowtimeEntity> showtimes;

        if (roomId != null && movieId != null && date != null) {
            LocalDateTime start = date.atStartOfDay();
            LocalDateTime end = date.atTime(LocalTime.MAX);

            RoomEntity roomEntity = roomListCrudRepository.findById(roomId)
                    .orElseThrow(()-> new NotFoundException("Room Not Found"));

            MovieEntity movie = movieListCrudRepository.findById(movieId)
                    .orElseThrow(()-> new NotFoundException("Movie Not Found"));

            showtimes = pagSortRepository.findByRoomAndMovieAndStartTimeBetween(roomEntity, movie, start, end, pageable);

        } else if (roomId != null && movieId != null) {

            RoomEntity room = roomListCrudRepository.findById(roomId)
                    .orElseThrow(()-> new NotFoundException("Room Not Found"));

            MovieEntity movie = movieListCrudRepository.findById(movieId)
                    .orElseThrow(()-> new NotFoundException("Movie Not Found"));

            showtimes = pagSortRepository.findByRoomAndMovie(room, movie, pageable);

        } else if (roomId != null && date != null) {

            LocalDateTime start = date.atStartOfDay();
            LocalDateTime end = date.atTime(LocalTime.MAX);

            RoomEntity room = roomListCrudRepository.findById(roomId)
                    .orElseThrow(()-> new NotFoundException("Room Not Found"));

            showtimes = pagSortRepository.findByRoomAndStartTimeBetween(room, start, end, pageable);

        } else if (movieId != null && date != null) {
            LocalDateTime start = date.atStartOfDay();
            LocalDateTime end = date.atTime(LocalTime.MAX);

            MovieEntity movie = movieListCrudRepository.findById(movieId)
                    .orElseThrow(()-> new NotFoundException("Movie Not Found"));

            showtimes = pagSortRepository.findByMovieAndStartTimeBetween(movie, start, end, pageable);

        } else if (roomId != null) {

            RoomEntity room = roomListCrudRepository.findById(roomId)
                    .orElseThrow(()-> new NotFoundException("Room Not Found"));
            showtimes = pagSortRepository.findByRoom(room, pageable);

        } else if (movieId != null) {
            MovieEntity movie = movieListCrudRepository.findById(movieId)
                    .orElseThrow(()-> new NotFoundException("Movie Not Found"));
            showtimes = pagSortRepository.findByMovie(movie, pageable);

        } else {
            showtimes = pagSortRepository.findAll(pageable); // sin filtros
        }

        return showtimes.map(mapper::toDTO);
    }

    @Override
    public ShowTime getById(Long id) {
        ShowtimeEntity showtimeEntity = this.showTimeListCrudRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Show Time Not Found"));
        return this.mapper.toDTO(showtimeEntity);
    }

    @Override
    public ShowTime create(CreateShowTimeRequest request) {
        RoomEntity room = roomListCrudRepository.findById(request.getRoomId())
                .orElseThrow(()-> new NotFoundException("Room Not Found"));

        MovieEntity movie = movieListCrudRepository.findById(request.getMovieId())
                .orElseThrow(()-> new NotFoundException("Movie Not Found"));

        ShowtimeEntity entity = ShowtimeEntity.builder()
                .startTime(request.getStartTime())
                .room(room)
                .movie(movie)
                .build();

        return this.mapper.toDTO(this.showTimeListCrudRepository.save(entity));
    }
}
