package com.fiap.cp5.repository;

import com.fiap.cp5.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {}
