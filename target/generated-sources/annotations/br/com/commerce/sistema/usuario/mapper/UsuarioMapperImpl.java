package br.com.commerce.sistema.usuario.mapper;

import br.com.commerce.sistema.conta.model.ContaEntity;
import br.com.commerce.sistema.conta.model.ContaSaida;
import br.com.commerce.sistema.usuario.model.UsuarioEntity;
import br.com.commerce.sistema.usuario.model.UsuarioEntrada;
import br.com.commerce.sistema.usuario.model.UsuarioSaida;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-03-27T11:10:09-0300",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 1.8.0_241 (Oracle Corporation)"
)
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public UsuarioEntity converterEntradaParaEntity(UsuarioEntrada entrada, List<ContaEntity> listaContas) {
        if ( entrada == null && listaContas == null ) {
            return null;
        }

        UsuarioEntity usuarioEntity = new UsuarioEntity();

        if ( entrada != null ) {
            usuarioEntity.setNome( entrada.getNome() );
            usuarioEntity.setIdade( entrada.getIdade() );
        }
        if ( listaContas != null ) {
            List<ContaEntity> list = listaContas;
            if ( list != null ) {
                usuarioEntity.setListaContas( new ArrayList<ContaEntity>( list ) );
            }
        }

        return usuarioEntity;
    }

    @Override
    public UsuarioSaida converterEntityParaSaida(UsuarioEntity entidade) {
        if ( entidade == null ) {
            return null;
        }

        UsuarioSaida usuarioSaida = new UsuarioSaida();

        usuarioSaida.setId( entidade.getId() );
        usuarioSaida.setNome( entidade.getNome() );
        usuarioSaida.setIdade( entidade.getIdade() );
        usuarioSaida.setListaContas( contaEntityListToContaSaidaList( entidade.getListaContas() ) );

        return usuarioSaida;
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
}
