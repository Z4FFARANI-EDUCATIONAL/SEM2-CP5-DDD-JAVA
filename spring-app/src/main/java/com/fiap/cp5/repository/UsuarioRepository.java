package com.fiap.cp5.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.fiap.cp5.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> { }