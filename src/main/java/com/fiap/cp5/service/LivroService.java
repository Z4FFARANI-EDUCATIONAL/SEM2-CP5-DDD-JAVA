package com.fiap.cp5.service;

import com.fiap.cp5.model.Livro;
import com.fiap.cp5.repository.LivroRepository;
import org.springframework.stereotype.Service;
import java.util.List;

// Camada que contém a lógica de negócios da aplicação. Nela é feita o CCRUD evita sobrecarregamento do controller não esqeucer de imoprtar o model e o repository //

// CRUD propriamente dito

@Service
public class LivroService {
    private final LivroRepository repository;

    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    public List<Livro> listarTodos() {
        return repository.findAll();
    }

    public Livro salvar(Livro livro) {
        return repository.save(livro);
    }

    public Livro buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
