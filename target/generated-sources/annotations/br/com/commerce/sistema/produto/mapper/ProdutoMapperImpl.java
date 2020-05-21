package br.com.commerce.sistema.produto.mapper;

import br.com.commerce.sistema.produto.model.ProdutoEntity;
import br.com.commerce.sistema.produto.model.ProdutoEntrada;
import br.com.commerce.sistema.produto.model.ProdutoSaida;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-03-27T11:10:10-0300",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 1.8.0_241 (Oracle Corporation)"
)
public class ProdutoMapperImpl implements ProdutoMapper {

    @Override
    public ProdutoEntity converterEntradaParaEntity(ProdutoEntrada entrada) {
        if ( entrada == null ) {
            return null;
        }

        ProdutoEntity produtoEntity = new ProdutoEntity();

        produtoEntity.setNomeProduto( entrada.getNomeProduto() );

        return produtoEntity;
    }

    @Override
    public ProdutoSaida converterEntityParaSaida(ProdutoEntity entidade) {
        if ( entidade == null ) {
            return null;
        }

        ProdutoSaida produtoSaida = new ProdutoSaida();

        produtoSaida.setId( entidade.getId() );
        produtoSaida.setNomeProduto( entidade.getNomeProduto() );

        return produtoSaida;
    }
}
