package br.com.commerce.sistema.conta.mapper;

import br.com.commerce.sistema.conta.model.ContaEntity;
import br.com.commerce.sistema.conta.model.ContaEntrada;
import br.com.commerce.sistema.conta.model.ContaSaida;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContaMapper {
    ContaMapper Instance = Mappers.getMapper(ContaMapper.class);

    ContaEntity converterEntradaParaEntity(ContaEntrada entrada);
    ContaSaida converterEntityParaSaida(ContaEntity entidade);

}
