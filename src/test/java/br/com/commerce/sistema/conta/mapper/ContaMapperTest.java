package br.com.commerce.sistema.conta.mapper;

import br.com.commerce.sistema.conta.model.ContaEntity;
import br.com.commerce.sistema.conta.model.ContaEntrada;
import br.com.commerce.sistema.conta.model.ContaSaida;
import br.com.commerce.sistema.produto.model.ProdutoEntity;
import br.com.commerce.sistema.produto.model.ProdutoEntrada;
import br.com.commerce.sistema.templates.ContaEntityTemplate;
import br.com.commerce.sistema.templates.ContaEntradaTemplate;
import br.com.commerce.sistema.templates.ProdutoEntradaTemplate;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ContaMapperTest {

    private ContaMapper contaMapper = Mappers.getMapper(ContaMapper.class);

    @Before
    public void setup(){
        FixtureFactoryLoader.loadTemplates("br.com.commerce.sistema.templates");
    }

    @Test
    public void deveConverterEntradaParaEntity(){
        //given
        ContaEntrada contaEntrada = Fixture.from(ContaEntrada.class).gimme(ContaEntradaTemplate.CONTA_TEMPLATE_VALIDO);

        //when
        ContaEntity contaEntity = contaMapper.converterEntradaParaEntity(contaEntrada);

        //then
        Assert.assertEquals(contaEntrada.getNumeroConta(), contaEntity.getNumeroConta());
        Assert.assertEquals(contaEntrada.getTipoConta(), contaEntity.getTipoConta());
    }

    @Test
    public void deveConverterEntityParaSaida(){
        //given
        ContaEntity contaEntity = Fixture.from(ContaEntity.class).gimme(ContaEntityTemplate.CONTA_TEMPLATE_VALIDO_PREMIUM);

        //when
        ContaSaida contaSaida = contaMapper.converterEntityParaSaida(contaEntity);

        //then
        Assert.assertEquals(contaSaida.getNumeroConta(), contaEntity.getNumeroConta());
        Assert.assertEquals(contaSaida.getTipoConta(), contaEntity.getTipoConta());
        Assert.assertEquals(contaSaida.getStatus(), contaEntity.getStatus());
    }
}
