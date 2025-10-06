package com.fiap.cp5.controller;

import com.fiap.cp5.model.Emprestimo;
import com.fiap.cp5.service.EmprestimoService;
import com.fiap.cp5.service.LivroService;
import com.fiap.cp5.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/emprestimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @Autowired
    private LivroService livroService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("emprestimos", emprestimoService.listarTodos());
        return "emprestimos/listar";
    }

    @GetMapping("/registrar")
    public String registrarForm(Model model) {
        model.addAttribute("emprestimo", new Emprestimo());
        model.addAttribute("livros", livroService.listarDisponiveis());
        model.addAttribute("usuarios", usuarioService.listarTodos());
        return "emprestimos/registrar";
    }

    @PostMapping("/registrar")
    public String salvar(@Valid @ModelAttribute("emprestimo") Emprestimo emprestimo,
                        BindingResult result,
                        @RequestParam("livro") Long livroId,
                        @RequestParam("usuario") Long usuarioId,
                        Model model) {

        model.addAttribute("livros", livroService.listarDisponiveis());
        model.addAttribute("usuarios", usuarioService.listarTodos());

        if (result.hasErrors()) {
            return "emprestimos/registrar";
        }

        try {
            emprestimoService.registrarEmprestimo(emprestimo, livroId, usuarioId);
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "emprestimos/registrar";
        }

        return "redirect:/emprestimos";
    }

    @PostMapping("/devolver/{id}")
    public String devolver(@PathVariable Long id) {
        emprestimoService.devolverEmprestimo(id);
        return "redirect:/emprestimos";
    }
}