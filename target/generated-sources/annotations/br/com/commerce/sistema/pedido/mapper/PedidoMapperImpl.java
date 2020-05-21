package br.com.commerce.sistema.pedido.mapper;

import br.com.commerce.sistema.conta.model.ContaEntity;
import br.com.commerce.sistema.conta.model.ContaSaida;
import br.com.commerce.sistema.pedido.model.PedidoEntity;
import br.com.commerce.sistema.pedido.model.PedidoEntrada;
import br.com.commerce.sistema.pedido.model.PedidoSaida;
import br.com.commerce.sistema.produto.model.ProdutoEntity;
import br.com.commerce.sistema.produto.model.ProdutoSaida;
import br.com.commerce.sistema.usuario.model.UsuarioEntity;
import br.com.commerce.sistema.usuario.model.UsuarioSaida;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-03-27T11:10:10-0300",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 1.8.0_241 (Oracle Corporation)"
)
public class PedidoMapperImpl implements PedidoMapper {

    @Override
    public PedidoEntity converterEntradaParaEntity(PedidoEntrada entrada, UsuarioEntity usuario, List<ProdutoEntity> listaProduto) {
        if ( entrada == null && usuario == null && listaProduto == null ) {
            return null;
        }

        PedidoEntity pedidoEntity = new PedidoEntity();

        if ( usuario != null ) {
            pedidoEntity.setUsuario( usuario );
        }
        if ( listaProduto != null ) {
            List<ProdutoEntity> list = listaProduto;
            if ( list != null ) {
                pedidoEntity.setListaProduto( new ArrayList<ProdutoEntity>( list ) );
            }
        }

        return pedidoEntity;
    }

    @Override
    public PedidoSaida converterEntityParaSaida(PedidoEntity entidade) {
        if ( entidade == null ) {
            return null;
        }

        PedidoSaida pedidoSaida = new PedidoSaida();

        pedidoSaida.setId( entidade.getId() );
        pedidoSaida.setUsuario( usuarioEntityToUsuarioSaida( entidade.getUsuario() ) );
        pedidoSaida.setListaProduto( produtoEntityListToProdutoSaidaList( entidade.getListaProduto() ) );

        return pedidoSaida;
    }

    protected ContaSaida contaEntityToContaSaida(ContaEntity contaEntity) {
        if ( contaEntity == null ) {
            return null;
        }

        ContaSaida contaSaida = new ContaSaida();

        contaSaida.setId( contaEntity.getId() );
        contaSaida.setNumeroConta( contaEntity.getNumeroConta() );
        contaSaida.setTipoConta( contaEntity.getTipoConta() );
        contaSaida.setStatus( contaEntity.getStatus() );

        return contaSaida;
    }

    protected List<ContaSaida> contaEntityListToContaSaidaList(List<ContaEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<ContaSaida> list1 = new ArrayList<ContaSaida>( list.size() );
        for ( ContaEntity contaEntity : list ) {
            list1.add( contaEntityToContaSaida( contaEntity ) );
        }

        return list1;
    }

    protected UsuarioSaida usuarioEntityToUsuarioSaida(UsuarioEntity usuarioEntity) {
        if ( usuarioEntity == null ) {
            return null;
        }

        UsuarioSaida usuarioSaida = new UsuarioSaida();

        usuarioSaida.setId( usuarioEntity.getId() );
        usuarioSaida.setNome( usuarioEntity.getNome() );
        usuarioSaida.setIdade( usuarioEntity.getIdade() );
        usuarioSaida.setListaContas( contaEntityListToContaSaidaList( usuarioEntity.getListaContas() ) );

        return usuarioSaida;
    }

    protected ProdutoSaida produtoEntityToProdutoSaida(ProdutoEntity produtoEntity) {
        if ( produtoEntity == null ) {
            return null;
        }

        ProdutoSaida produtoSaida = new ProdutoSaida();

        produtoSaida.setId( produtoEntity.getId() );
        produtoSaida.setNomeProduto( produtoEntity.getNomeProduto() );

        return produtoSaida;
    }

    protected List<ProdutoSaida> produtoEntityListToProdutoSaidaList(List<ProdutoEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<ProdutoSaida> list1 = new ArrayList<ProdutoSaida>( list.size() );
        for ( ProdutoEntity produtoEntity : list ) {
            list1.add( produtoEntityToProdutoSaida( produtoEntity ) );
        }

        return list1;
    }
}
