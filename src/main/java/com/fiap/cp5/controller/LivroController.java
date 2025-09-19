package com.fiap.cp5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.ui.Model;

import com.fiap.cp5.model.Livro;
import com.fiap.cp5.service.LivroService;

// Responsável pelas requisições HTTP (GET, POST, PUT, DELETE)
// Porta de entrada da aplicação
// Interage com a camada Service para buscar / tratar dados e Retorna a resposta (página tymeleaf ou Json em API)

@Controller
@RequestMapping("/livros")
public class LivroController {
    private final LivroService service;

    public LivroController(LivroService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("listaLivros", service.listarTodos());
        return "livros";
    }

    @GetMapping("/novo")
    public String novoLivroForm(Model model) {
        model.addAttribute("livro", new Livro());
        return "form";
    }

    @PostMapping
    public String salvar(@ModelAttribute Livro livro) {
        service.salvar(livro);
        return "redirect:/livros";
    }

    @GetMapping("/editar/{id}")
    public String editarProduto(@PathVariable Long id, Model model) {
        model.addAttribute("livro", service.buscarPorId(id));
        return "form";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        service.deletar(id);
        return "redirect:/livros";
    }
}