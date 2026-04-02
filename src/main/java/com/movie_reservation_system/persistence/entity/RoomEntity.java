package com.movie_reservation_system.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "rooms")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer capacity;

    @OneToMany(mappedBy = "room")
    @OrderBy("seat_row ASC, seat_number ASC")
    private List<SeatEntity> seats;
}
