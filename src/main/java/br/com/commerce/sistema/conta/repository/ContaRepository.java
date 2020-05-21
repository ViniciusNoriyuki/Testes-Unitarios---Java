package br.com.commerce.sistema.conta.repository;

import br.com.commerce.sistema.conta.model.ContaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContaRepository extends JpaRepository<ContaEntity, Long> {
    List<ContaEntity> findByStatus(String status);
}
