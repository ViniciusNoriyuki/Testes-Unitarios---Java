package br.com.commerce.sistema.pedido.mapper;

import br.com.commerce.sistema.pedido.model.PedidoEntity;
import br.com.commerce.sistema.pedido.model.PedidoEntrada;
import br.com.commerce.sistema.pedido.model.PedidoSaida;
import br.com.commerce.sistema.produto.model.ProdutoEntity;
import br.com.commerce.sistema.usuario.model.UsuarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PedidoMapper {

    PedidoMapper Instance = Mappers.getMapper(PedidoMapper.class);

    @Mappings({
            @Mapping(target = "usuario", source = "usuario"),
            @Mapping(target = "listaProduto", source = "listaProduto"),
            @Mapping(target = "id", ignore = true)
    })

    PedidoEntity converterEntradaParaEntity (PedidoEntrada entrada, UsuarioEntity usuario, List<ProdutoEntity> listaProduto);
    PedidoSaida converterEntityParaSaida (PedidoEntity entidade);
}

