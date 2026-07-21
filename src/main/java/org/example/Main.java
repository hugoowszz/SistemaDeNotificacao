package org.example;

import org.example.entity.ReciboImutavel;
import org.example.service.GerenciadorNotificacoes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== INICIANDO SISTEMA DE NOTIFICAÇÕES ===\n");

        List<ReciboImutavel> recibos = List.of(
            new ReciboImutavel(1, "1234-1234", "NotificacaoSms", true, LocalDateTime.now()),
            new ReciboImutavel(2, "4321-4321", "NotificacaoSms", false, LocalDateTime.now()),
            new ReciboImutavel(2, "teste@teste.com", "NotificacaoEmail", true, LocalDateTime.now()),
            new ReciboImutavel(4, "tes@te.com", "NotificacaoEmail", true, LocalDateTime.now())
        );

        GerenciadorNotificacoes gerenciadorNotificacoes = new GerenciadorNotificacoes();
        Map<Boolean, Set<ReciboImutavel>> recibosPorStatus = gerenciadorNotificacoes.agruparPorStatus(recibos);
        System.out.println(gerenciadorNotificacoes.obterEmailsSucesso(recibos));
    }
}