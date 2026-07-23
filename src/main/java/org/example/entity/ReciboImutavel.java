package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "recibos_notificacao")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReciboImutavel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String destinatario;
    String mensagem;
    String canal;
    Boolean sucesso;

    @Column(name = "data_envio")
    LocalDateTime dataHora;
}
