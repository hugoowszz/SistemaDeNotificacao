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
                new ReciboImutavel(1, "1234-1234", "NotificacaoSms", true, LocalDateTime.now().minusHours(5)),
                new ReciboImutavel(2, "4321-4321", "NotificacaoSms", false, LocalDateTime.now().minusHours(2)),
                new ReciboImutavel(3, "teste@teste.com", "NotificacaoEmail", true, LocalDateTime.now().minusHours(1)),
                new ReciboImutavel(4, "tes@te.com", "NotificacaoEmail", true, LocalDateTime.now().minusHours(8)),
                new ReciboImutavel(5, "carlos@email.com,admin@email.com,suporte@email.com", "NotificacaoEmail", true, LocalDateTime.now()),
                new ReciboImutavel(6, "token-app-123", "NotificacaoPush", true, LocalDateTime.now().minusHours(3)),
                new ReciboImutavel(7, "token-app-456", "NotificacaoPush", false, LocalDateTime.now().minusHours(7)),
                new ReciboImutavel(8, "9999-9999,8888-8888", "NotificacaoSms", true, LocalDateTime.now().minusHours(4))
        );

        GerenciadorNotificacoes gerenciadorNotificacoes = new GerenciadorNotificacoes();
        Map<Boolean, Set<ReciboImutavel>> recibosPorStatus = gerenciadorNotificacoes.agruparPorStatus(recibos);
        System.out.println(gerenciadorNotificacoes.filtrarLista(recibos, recibo -> !recibo.sucesso()));
    }
}