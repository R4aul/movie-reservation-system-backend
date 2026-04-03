package com.movie_reservation_system.domain.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateShowTimeRequest {

    @NotNull(message = "La fecha y hora de inicio es obligatoria")
    @Future(message = "La fecha y hora debe ser posterior a la actual")
    private LocalDateTime startTime;

    @NotNull(message = "La sala es obligatoria")
    private Integer roomId;

    @NotNull(message = "La pelicula es obligatoria")
    private Long movieId;

}
