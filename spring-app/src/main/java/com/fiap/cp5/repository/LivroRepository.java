package com.fiap.cp5.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.fiap.cp5.model.Livro;
import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByStatus(String status);
}