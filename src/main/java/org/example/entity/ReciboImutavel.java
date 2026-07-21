package org.example.entity;

import java.time.LocalDateTime;

public record ReciboImutavel(int id, String destinatario, String canal, Boolean sucesso, LocalDateTime dataHora) {
}
