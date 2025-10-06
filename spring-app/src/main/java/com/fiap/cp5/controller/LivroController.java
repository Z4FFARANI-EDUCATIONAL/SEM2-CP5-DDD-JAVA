package com.fiap.cp5.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.fiap.cp5.model.Livro;
import com.fiap.cp5.service.LivroService;

@Controller
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("livros", livroService.listarTodos());
        return "livros/listar";
    }

    @GetMapping("/disponiveis")
    public String listarDisponiveis(Model model) {
        model.addAttribute("livros", livroService.listarDisponiveis());
        return "livros/listar";
    }

    @GetMapping("/cadastrar")
    public String cadastrar(Model model) {
        model.addAttribute("livro", new Livro());
        return "livros/cadastrar";
    }

    @PostMapping("/cadastrar")
    public String salvar(@Valid Livro livro, BindingResult result) {
        if (result.hasErrors()) return "livros/cadastrar";

        try {
            livroService.inserir(livro);
        } catch (IllegalArgumentException e) {
            result.rejectValue("titulo", "error.livro", e.getMessage());
            return "livros/cadastrar";
        }

        return "redirect:/livros";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Livro livro = livroService.buscarPorId(id);
        if (livro == null) {
            return "redirect:/livros";
        }
        model.addAttribute("livro", livro);
        return "livros/editar";
    }

    @PostMapping("/editar/{id}")
    public String atualizar(@PathVariable Long id, @Valid Livro livro, Model model) {
        try {
            livroService.editar(id, livro);
            return "redirect:/livros";
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            model.addAttribute("livros", livroService.listarTodos());
            return "livros/editar";
        }
    }

    @PostMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id, Model model) {
        try {
            livroService.excluir(id);
            return "redirect:/livros";
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            model.addAttribute("livros", livroService.listarTodos());
            return "livros/listar";
        }
    }
}