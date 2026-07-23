package org.example.entity.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioRequest(
        @NotBlank(message = "O nome não pode estar em branco")
        String nome,
        @NotBlank(message = "O email não pode estar em branco")
        @Email
        String email
) {
}
