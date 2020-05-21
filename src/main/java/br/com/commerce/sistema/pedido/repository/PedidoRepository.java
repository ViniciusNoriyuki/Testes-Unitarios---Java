package br.com.commerce.sistema.pedido.repository;

import br.com.commerce.sistema.pedido.model.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {
}
