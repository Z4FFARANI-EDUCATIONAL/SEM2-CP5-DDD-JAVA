package com.fiap.cp5.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.fiap.cp5.model.Usuario;
import com.fiap.cp5.service.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("usuarios", usuarioService.listarTodos());
        return "usuarios/listar";
    }

    @GetMapping("/cadastrar")
    public String cadastrar(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarios/cadastrar";
    }

    @PostMapping("/cadastrar")
    public String salvar(@Valid @ModelAttribute Usuario usuario, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "usuarios/cadastrar";
        }

        try {
            usuarioService.inserir(usuario);
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "usuarios/cadastrar";
        }

        return "redirect:/usuarios";
    }
}