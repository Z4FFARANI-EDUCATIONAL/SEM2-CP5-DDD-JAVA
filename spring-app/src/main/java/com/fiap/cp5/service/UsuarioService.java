package com.fiap.cp5.service;

import com.fiap.cp5.model.Usuario;
import com.fiap.cp5.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<Usuario> listarTodos() {
        return repository.findAll();
    }

    public Usuario inserir(Usuario usuario) {
        if (usuario.getNome() == null || usuario.getNome().isEmpty()) {
            throw new IllegalArgumentException("O nome do Usuário não pode ser vazio.");
        } 
        if (usuario.getEmail() == null || 
            !usuario.getEmail().contains("@") || 
            !usuario.getEmail().contains(".com")) {
            throw new IllegalArgumentException("Endereço de email inválido.");
        }

        return repository.save(usuario);
    }
}