package com.fiap.cp5.repository;

import com.fiap.cp5.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

// É uma interface que herda de jparepository que fornece subsídios para impelementar o CRUD
// jpa repository é o que faz acesso ao banco de dados
public interface LivroRepository extends JpaRepository<Livro, Long> {}
