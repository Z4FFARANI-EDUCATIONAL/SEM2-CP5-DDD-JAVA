package com.fiap.cp5.service;

import com.fiap.cp5.model.Livro;
import com.fiap.cp5.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LivroService {

    private final LivroRepository repository;

    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    public Livro buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Livro> listarTodos() {
        return repository.findAll();
    }

    public List<Livro> listarDisponiveis() {
        return repository.findByStatus("Disponível");
    }

    public Livro inserir(Livro livro) {
        if (livro.getTitulo() == null || livro.getTitulo().isBlank()) {
            throw new IllegalArgumentException("O título do livro não pode ser vazio.");
        } if (livro.getAnoPublicacao() > LocalDate.now().getYear()) {
            throw new IllegalArgumentException("O ano de publicação não pode ser maior que o ano atual.");
        }
        livro.setStatus("Disponível");
        return repository.save(livro);
    }

    public Livro editar(Long id, Livro livroAtualizado) {
        return repository.findById(id).map(livroExistente -> {
            if (livroAtualizado.getTitulo() != null && !livroAtualizado.getTitulo().isBlank()) {
                livroExistente.setTitulo(livroAtualizado.getTitulo());
            }
            if (livroAtualizado.getAutor() != null) {
                livroExistente.setAutor(livroAtualizado.getAutor());
            }
            if (livroAtualizado.getAnoPublicacao() > LocalDate.now().getYear()) {
                throw new IllegalArgumentException("O ano de publicação não pode ser maior que o ano atual.");
            } else {
                if (livroAtualizado.getAnoPublicacao() != null) {
                    livroExistente.setAnoPublicacao(livroAtualizado.getAnoPublicacao());
                }
            }
            if (livroAtualizado.getStatus() != null) {
                livroExistente.setStatus(livroAtualizado.getStatus());
            }
            return repository.save(livroExistente);
        }).orElse(null);
    }

    public void excluir(Long id) {
        Livro livroEncontrado = buscarPorId(id);
        if ("Emprestado".equals(livroEncontrado.getStatus())) {
            throw new IllegalArgumentException("Livros não devolvidos não podem ser excluídos.");
        } else {
            repository.deleteById(id);
        }
    }
}