package com.movie_reservation_system.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginRequest(
        @Email(message = "El campo no es de tipo correo electronico")
        String email,

        @NotBlank(message = "El campo correo es obligatorio")
        String password
) {
}
