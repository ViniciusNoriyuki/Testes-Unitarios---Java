package br.com.commerce.sistema.usuario.repository;

import br.com.commerce.sistema.usuario.model.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
}
