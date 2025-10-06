package com.fiap.cp5.service;

import com.fiap.cp5.model.Emprestimo;
import com.fiap.cp5.model.Livro;
import com.fiap.cp5.model.Usuario;
import com.fiap.cp5.repository.EmprestimoRepository;
import com.fiap.cp5.repository.LivroRepository;
import com.fiap.cp5.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;
    private final LivroRepository livroRepository;
    private final UsuarioRepository usuarioRepository;

    public EmprestimoService(EmprestimoRepository emprestimoRepository,
                             LivroRepository livroRepository,
                             UsuarioRepository usuarioRepository) {
        this.emprestimoRepository = emprestimoRepository;
        this.livroRepository = livroRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<Emprestimo> listarTodos() {
        return emprestimoRepository.findAllByOrderByDataDevolucaoAsc();
    }

    public void registrarEmprestimo(Emprestimo emprestimo, Long livroId, Long usuarioId) {
        Livro livro = livroRepository.findById(livroId)
                .orElseThrow(() -> new IllegalArgumentException("Livro não encontrado"));

        if ("Emprestado".equalsIgnoreCase(livro.getStatus())) {
            throw new IllegalArgumentException("O livro já está emprestado");
        }

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        if (!emprestimo.getDataRetirada().isBefore(emprestimo.getDataDevolucao())) {
            throw new IllegalArgumentException("A data de devolução deve ser posterior à data de retirada");
        }

        livro.setStatus("Emprestado");
        livroRepository.save(livro);

        emprestimo.setLivro(livro);
        emprestimo.setUsuario(usuario);
        emprestimoRepository.save(emprestimo);
    }

    public void devolverEmprestimo(Long id) {
        Emprestimo emprestimo = emprestimoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Empréstimo não encontrado"));

        Livro livro = emprestimo.getLivro();
        livro.setStatus("Disponível");
        livroRepository.save(livro);

        emprestimoRepository.delete(emprestimo);
    }
}