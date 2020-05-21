package br.com.commerce.sistema.produto.mapper;

import br.com.commerce.sistema.produto.model.ProdutoEntity;
import br.com.commerce.sistema.produto.model.ProdutoEntrada;
import br.com.commerce.sistema.produto.model.ProdutoSaida;
import br.com.commerce.sistema.templates.ProdutoEntityTemplate;
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
public class ProdutoMapperTest {

    private ProdutoMapper produtoMapper = Mappers.getMapper(ProdutoMapper.class);

    @Before
    public void setup(){
        FixtureFactoryLoader.loadTemplates("br.com.commerce.sistema.templates");
    }

    @Test
    public void deveConverterEntradaParaEntity(){
        //given
        ProdutoEntrada produtoEntrada = Fixture.from(ProdutoEntrada.class).gimme(ProdutoEntradaTemplate.PRODUTO_TEMPLATE_VALIDO);

        //when
        ProdutoEntity produtoEntity = produtoMapper.converterEntradaParaEntity(produtoEntrada);

        //then
        Assert.assertEquals(produtoEntrada.getNomeProduto(), produtoEntity.getNomeProduto());
    }

    @Test
    public void deveConverterEntityParaSaida(){
        //given
        ProdutoEntity produtoEntity = Fixture.from(ProdutoEntity.class).gimme(ProdutoEntityTemplate.PRODUTO_TEMPLATE_VALIDO);

        //when
        ProdutoSaida produtoSaida = produtoMapper.converterEntityParaSaida(produtoEntity);

        //then
        Assert.assertEquals(produtoEntity.getNomeProduto(), produtoSaida.getNomeProduto());
    }
}
