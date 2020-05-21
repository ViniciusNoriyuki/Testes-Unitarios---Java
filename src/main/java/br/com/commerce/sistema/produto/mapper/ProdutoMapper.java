package br.com.commerce.sistema.produto.mapper;

import br.com.commerce.sistema.produto.model.ProdutoEntity;
import br.com.commerce.sistema.produto.model.ProdutoEntrada;
import br.com.commerce.sistema.produto.model.ProdutoSaida;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProdutoMapper {

    ProdutoMapper Instance = Mappers.getMapper(ProdutoMapper.class);

    ProdutoEntity converterEntradaParaEntity(ProdutoEntrada entrada);
    ProdutoSaida converterEntityParaSaida(ProdutoEntity entidade);

}

