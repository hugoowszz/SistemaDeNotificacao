package org.example.controller;

import jakarta.validation.Valid;
import org.example.config.exception.ErrorEntity;
import org.example.config.exception.UsuarioNaoEncontradoException;
import org.example.entity.Usuario;
import org.example.entity.dto.request.UsuarioRequest;
import org.example.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/usuarios")
    public ResponseEntity<Usuario> criarUsuario(@RequestBody @Valid UsuarioRequest request) {
        return ResponseEntity.status(201).body(usuarioService.criarUsuario(request.nome(), request.email()));
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable @Valid int id) {
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorId(id));
    }

    @PutMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable @Valid int id, @RequestBody @Valid UsuarioRequest request) {
        return ResponseEntity.ok(usuarioService.atualizarUsuario(id, request.nome(), request.email()));
    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> excluirUsuario(@PathVariable @Valid int id) {
        usuarioService.excluirUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
