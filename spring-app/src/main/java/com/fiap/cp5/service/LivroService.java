package com.fiap.cp5.service;

import com.fiap.cp5.model.Livro;
import com.fiap.cp5.repository.LivroRepository;
import org.springframework.stereotype.Service;
import java.util.List;

// Camada que contém a lógica de negócios da aplicação. Nela é feita o CRUD evita sobrecarregamento do controller não esquecer de importar o model e o repository //

// CRUD propriamente dito

// listar, inserir (cadastrar -> precisa definir status disponível), editar e excluir

// listar apenas livros disponíveis

// VALIDAÇÃO
// livro não pode ter título vazio

@Service
public class LivroService {
    private final LivroRepository repository;

    // manter
    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    // manter
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
