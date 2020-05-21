package br.com.commerce.sistema.conta.mapper;

import br.com.commerce.sistema.conta.model.ContaEntity;
import br.com.commerce.sistema.conta.model.ContaEntrada;
import br.com.commerce.sistema.conta.model.ContaSaida;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-03-27T11:10:09-0300",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 1.8.0_241 (Oracle Corporation)"
)
public class ContaMapperImpl implements ContaMapper {

    @Override
    public ContaEntity converterEntradaParaEntity(ContaEntrada entrada) {
        if ( entrada == null ) {
            return null;
        }

        ContaEntity contaEntity = new ContaEntity();

        contaEntity.setNumeroConta( entrada.getNumeroConta() );
        contaEntity.setTipoConta( entrada.getTipoConta() );

        return contaEntity;
    }

    @Override
    public ContaSaida converterEntityParaSaida(ContaEntity entidade) {
        if ( entidade == null ) {
            return null;
        }

        ContaSaida contaSaida = new ContaSaida();

        contaSaida.setId( entidade.getId() );
        contaSaida.setNumeroConta( entidade.getNumeroConta() );
        contaSaida.setTipoConta( entidade.getTipoConta() );
        contaSaida.setStatus( entidade.getStatus() );

        return contaSaida;
    }
}
