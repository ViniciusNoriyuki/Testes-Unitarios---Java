package br.com.commerce.sistema.usuario.mapper;

import br.com.commerce.sistema.conta.model.ContaEntity;
import br.com.commerce.sistema.usuario.model.UsuarioEntity;
import br.com.commerce.sistema.usuario.model.UsuarioEntrada;
import br.com.commerce.sistema.usuario.model.UsuarioSaida;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UsuarioMapper {

    UsuarioMapper Instance = Mappers.getMapper(UsuarioMapper.class);

    UsuarioEntity converterEntradaParaEntity (UsuarioEntrada entrada, List<ContaEntity> listaContas);
    UsuarioSaida converterEntityParaSaida (UsuarioEntity entidade);
}
