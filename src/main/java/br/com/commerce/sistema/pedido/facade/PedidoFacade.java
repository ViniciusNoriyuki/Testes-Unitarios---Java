package br.com.commerce.sistema.pedido.facade;

import br.com.commerce.sistema.pedido.mapper.PedidoMapper;
import br.com.commerce.sistema.pedido.model.PedidoEntity;
import br.com.commerce.sistema.pedido.model.PedidoEntrada;
import br.com.commerce.sistema.pedido.model.PedidoSaida;
import br.com.commerce.sistema.pedido.repository.PedidoRepository;
import br.com.commerce.sistema.produto.facade.ProdutoFacade;
import br.com.commerce.sistema.produto.model.ProdutoEntity;
import br.com.commerce.sistema.usuario.facade.UsuarioFacade;
import br.com.commerce.sistema.usuario.model.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoFacade {

    @Autowired
    PedidoRepository pedidoRepository;
    @Autowired
    ProdutoFacade produtoFacade;
    @Autowired
    UsuarioFacade usuarioFacade;

    public PedidoSaida criarPedido(PedidoEntrada entrada) throws Exception {

        // ENTRADA PARA ENTIDADE =>
        UsuarioEntity usuario = usuarioFacade.retornarUsuarioEntity(entrada.getUsuario());

        List<ProdutoEntity> listaProdutosEntity = preencherListaProdutos(entrada, usuario);

        PedidoEntity entidade = PedidoMapper.Instance.converterEntradaParaEntity(entrada, usuario, listaProdutosEntity);

        // ENTIDADE PARA BANCO =>
        entidade = pedidoRepository.save(entidade);

        // ENTIDADE PARA SAIDA
        PedidoSaida saida = PedidoMapper.Instance.converterEntityParaSaida(entidade);

        return saida;
    }

    public List<ProdutoEntity> preencherListaProdutos(PedidoEntrada entrada, UsuarioEntity usuarioEntity) throws Exception {
        List<ProdutoEntity> listaProdutos = new ArrayList<>();

        if (usuarioEntity.getListaContas().get(0).getTipoConta().equals("FREE") && entrada.getListaProduto().size() > 2){
            throw new Exception("Usuario free com mais de 2 produtos.");
        }

        for (int i = 0; i < entrada.getListaProduto().size(); i++){
            ProdutoEntity produtoEntity = produtoFacade.retornarProdutoEntity(entrada.getListaProduto().get(i));
            listaProdutos.add(produtoEntity);
        }

        return listaProdutos;
    }
}
