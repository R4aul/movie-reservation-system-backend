package com.movie_reservation_system.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "showtimes")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ShowtimeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @ManyToOne
    private MovieEntity movie;

    @ManyToOne
    private RoomEntity room;
}
