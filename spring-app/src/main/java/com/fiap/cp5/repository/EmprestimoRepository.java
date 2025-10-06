package com.fiap.cp5.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.fiap.cp5.model.Emprestimo;
import java.util.List;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
    List<Emprestimo> findAllByOrderByDataDevolucaoAsc();
}