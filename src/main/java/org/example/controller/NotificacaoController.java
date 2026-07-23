package org.example.controller;

import org.example.entity.ReciboImutavel;
import org.example.repository.ReciboRepository;
import org.example.service.GerenciadorNotificacoes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NotificacaoController {

    @Autowired
    private GerenciadorNotificacoes gerenciadorNotificacoes;

    @Autowired
    private ReciboRepository repository;

    @GetMapping("/contatos")
    public ResponseEntity<List<String>> obterContatos() {
        return ResponseEntity.ok(gerenciadorNotificacoes.obterContatosUnicos(repository.findAll()));
    }

    @PostMapping("/disparar")
    public ResponseEntity<List<ReciboImutavel>> disparar(@RequestParam String destinatario, @RequestParam String mensagem) {
        return ResponseEntity.ok(gerenciadorNotificacoes.disparar(destinatario, mensagem));
    }

    @GetMapping("/recibos/status/{sucesso}")
    public ResponseEntity<List<ReciboImutavel>> buscarRecibosSucesso(@PathVariable Boolean sucesso) {
        return ResponseEntity.ok(gerenciadorNotificacoes.buscarRecibosDeSucesso(sucesso));
    }

    @GetMapping("/recibos/canal/{canal}")
    public ResponseEntity<List<ReciboImutavel>> buscarRecibosPorCanal(@PathVariable String canal) {
        return ResponseEntity.ok(gerenciadorNotificacoes.buscarRecibosPorCanal(canal));
    }

    @GetMapping("/recibos/dominio/{dominio}")
    public ResponseEntity<List<ReciboImutavel>> buscarRecibosPorDominio(@PathVariable String dominio) {
        return ResponseEntity.ok(gerenciadorNotificacoes.buscarRecibosPorDominio(dominio));
    }
}
