package br.com.commerce.sistema.produto.repository;

import br.com.commerce.sistema.produto.model.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {
}
