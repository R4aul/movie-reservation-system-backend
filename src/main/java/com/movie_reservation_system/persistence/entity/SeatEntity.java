package com.movie_reservation_system.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "seats")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SeatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "seat_row", length = 5)
    private String seatRow;

    @Column(name = "seat_number")
    private Integer seatNumber;

    @ManyToOne
    private RoomEntity room;
}
