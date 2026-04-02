package com.movie_reservation_system.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {

    @NotBlank(message = "El nombre es reequerido")
    private String name;

    @NotBlank(message = "El correo es reequerido")
    @Email(message = "No es un tipo de correo")
    private String email;

    @NotBlank(message = "La contraseña es requerida")
    @Size(
            min = 6,
            max = 16,
            message = "La Contraseña debe de tener almenos 6 a 16 caracteres"
    )
    private String password;
}
