package br.com.commerce.sistema.produto.facade;

import br.com.commerce.sistema.produto.model.ProdutoEntity;
import br.com.commerce.sistema.produto.model.ProdutoEntrada;
import br.com.commerce.sistema.produto.model.ProdutoSaida;
import br.com.commerce.sistema.produto.repository.ProdutoRepository;
import br.com.commerce.sistema.templates.ProdutoEntityTemplate;
import br.com.commerce.sistema.templates.ProdutoEntradaTemplate;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ProdutoFacadeTest {

    @InjectMocks
    ProdutoFacade produtoFacade;

    @Mock
    ProdutoRepository produtoRepository;

    @Before
    public void setup(){
        FixtureFactoryLoader.loadTemplates("br.com.commerce.sistema.templates");
    }

    @Test
    public void deveCriarProduto() throws Exception {
        //given
        ProdutoEntrada produtoEntrada = Fixture.from(ProdutoEntrada.class).gimme(ProdutoEntradaTemplate.PRODUTO_TEMPLATE_VALIDO);
        ProdutoEntity produtoEntity = Fixture.from(ProdutoEntity.class).gimme(ProdutoEntityTemplate.PRODUTO_TEMPLATE_VALIDO);
        Mockito.when(produtoRepository.save(Mockito.anyObject())).thenReturn(produtoEntity);

        //when
        ProdutoSaida produtoSaida = produtoFacade.criarProduto(produtoEntrada);

        //then
        Assert.assertNotNull(produtoEntrada);
    }

    @Test
    public void deveRetornarProdutoEntity() throws Exception {
        //given
        Long id = 1L;
        ProdutoEntity produtoEntity = Fixture.from(ProdutoEntity.class).gimme(ProdutoEntityTemplate.PRODUTO_TEMPLATE_VALIDO);
        Mockito.when(produtoRepository.findById(Mockito.anyLong())).thenReturn(java.util.Optional.ofNullable(produtoEntity));

        //when
        ProdutoEntity produtoEntityResultado = produtoFacade.retornarProdutoEntity(id);

        //then
        Assert.assertNotNull(produtoEntityResultado);
    }

    @Test(expected = java.lang.Exception.class)
    public void deveGerarErroRetornoProdutoEntityEmpity() throws Exception {
        //given
        Long id = 1L;

        //when
        produtoFacade.retornarProdutoEntity(id);
    }

}
