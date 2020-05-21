package br.com.commerce.sistema.pedido.model;

import br.com.commerce.sistema.produto.model.ProdutoSaida;
import br.com.commerce.sistema.usuario.model.UsuarioSaida;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoSaida {

    private Long id;
    private UsuarioSaida usuario;
    private List<ProdutoSaida> listaProduto;
}
