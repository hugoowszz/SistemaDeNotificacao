package org.example.service;

import org.example.config.exception.UsuarioNaoEncontradoException;
import org.example.entity.Usuario;
import org.example.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public Usuario criarUsuario(String nome, String email) {
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setData_cadastro(LocalDateTime.now());
        repository.save(usuario);
        return usuario;
    }

    public List<Usuario> listarUsuarios() {
        return repository.findAll();
    }

    public Usuario buscarUsuarioPorId(int id) {
        return repository.findById(id).orElseThrow(() -> new UsuarioNaoEncontradoException("Usuario não encontrado!"));
    }

    public Usuario atualizarUsuario(int id, String nome, String email) {
        Usuario usuario = repository.findById(id).orElseThrow(() -> new UsuarioNaoEncontradoException("Usuario não encontrado!"));
        usuario.setId(id);
        usuario.setNome(nome);
        usuario.setEmail(email);
        return repository.save(usuario);
    }

    public void excluirUsuario(int id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new UsuarioNaoEncontradoException("Usuario não encontrado!");
        }
    }
}
