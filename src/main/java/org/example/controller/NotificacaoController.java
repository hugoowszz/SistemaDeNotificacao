package org.example.controller;

import org.example.entity.ReciboImutavel;
import org.example.repository.ReciboRepository;
import org.example.service.GerenciadorNotificacoes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
