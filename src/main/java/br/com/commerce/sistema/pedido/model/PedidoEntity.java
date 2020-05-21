package br.com.commerce.sistema.pedido.model;

import br.com.commerce.sistema.produto.model.ProdutoEntity;
import br.com.commerce.sistema.usuario.model.UsuarioEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Pedido")
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne
    UsuarioEntity usuario;

    @ManyToMany
    List<ProdutoEntity> listaProduto;

}
