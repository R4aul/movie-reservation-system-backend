package com.movie_reservation_system.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class UpdateMovieRequest {
    @NotBlank(message = "El titulo no debe estar vacio")
    private String title;

    @NotNull(message = "La duracion es obligatoria")
    @Positive(message = "La duración debe ser mayor a 0")
    private Integer duration;

    @NotBlank(message = "El clasificacion no debe estar vacio")
    @Pattern(
            regexp = "G|PG|PG-13|R|NC-17",
            message = "Clasificacón Invalida"
    )
    private String rating;

    @NotNull(message = "El género es obligatorio")
    private Integer genreId;

}
