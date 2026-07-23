package org.example.entity.dto.request;

import jakarta.validation.constraints.NotBlank;

public record NotificationRequest(
        @NotBlank(message = "O destinatário não pode estar em branco")
        String destinatario,
        @NotBlank(message = "A mensagem não pode estar em branco")
        String mensagem
) {
}
