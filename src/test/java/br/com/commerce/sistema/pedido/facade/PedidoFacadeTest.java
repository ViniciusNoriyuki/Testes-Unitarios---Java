package br.com.commerce.sistema.pedido.facade;

import br.com.commerce.sistema.pedido.model.PedidoEntity;
import br.com.commerce.sistema.pedido.model.PedidoEntrada;
import br.com.commerce.sistema.pedido.model.PedidoSaida;
import br.com.commerce.sistema.pedido.repository.PedidoRepository;
import br.com.commerce.sistema.produto.facade.ProdutoFacade;
import br.com.commerce.sistema.produto.model.ProdutoEntity;
import br.com.commerce.sistema.templates.PedidoEntityTemplate;
import br.com.commerce.sistema.templates.PedidoEntradaTemplate;
import br.com.commerce.sistema.templates.ProdutoEntityTemplate;
import br.com.commerce.sistema.templates.UsuarioEntityTemplate;
import br.com.commerce.sistema.usuario.facade.UsuarioFacade;
import br.com.commerce.sistema.usuario.model.UsuarioEntity;
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
public class PedidoFacadeTest {

    @InjectMocks
    PedidoFacade pedidoFacade;

    @Mock
    PedidoRepository pedidoRepository;
    @Mock
    ProdutoFacade produtoFacade;
    @Mock
    UsuarioFacade usuarioFacade;

    @Before
    public void setup(){
        FixtureFactoryLoader.loadTemplates("br.com.commerce.sistema.templates");
    };

    @Test
    public void deveCriarPedido() throws Exception {
        //given
        PedidoEntrada pedidoEntrada = Fixture.from(PedidoEntrada.class).gimme(PedidoEntradaTemplate.PEDIDO_TEMPLATE_VALIDO);
        ProdutoEntity produtoEntity = Fixture.from(ProdutoEntity.class).gimme(ProdutoEntityTemplate.PRODUTO_TEMPLATE_VALIDO);
        PedidoEntity pedidoEntity = Fixture.from(PedidoEntity.class).gimme(PedidoEntityTemplate.PEDIDO_TEMPLATE_VALIDO);
        UsuarioEntity usuarioEntity = Fixture.from(UsuarioEntity.class).gimme(UsuarioEntityTemplate.USUARIO_TEMPLATE_VALIDO);
        Mockito.when(usuarioFacade.retornarUsuarioEntity(Mockito.anyLong())).thenReturn(usuarioEntity);
        Mockito.when(produtoFacade.retornarProdutoEntity(Mockito.anyLong())).thenReturn(produtoEntity);
        Mockito.when(pedidoRepository.save(Mockito.anyObject())).thenReturn(pedidoEntity);

        //when
        PedidoSaida pedidoSaida = pedidoFacade.criarPedido(pedidoEntrada);

        //then
        Assert.assertNotNull(pedidoSaida);

    }

    @Test(expected = java.lang.Exception.class)
    public void deveGerarErroPreencherListaProdutosFree() throws Exception {
        //given
        PedidoEntrada pedidoEntrada = Fixture.from(PedidoEntrada.class).gimme(PedidoEntradaTemplate.PEDIDO_TEMPLATE_INVALIDO_FREE);
        UsuarioEntity usuarioEntity = Fixture.from(UsuarioEntity.class).gimme(UsuarioEntityTemplate.USUARIO_TEMPLATE_VALIDO);

        //when
        pedidoFacade.preencherListaProdutos(pedidoEntrada, usuarioEntity);
    }

    @Test
    public void devePreencherListaProdutosPremium() throws Exception {
        //given
        PedidoEntrada pedidoEntrada = Fixture.from(PedidoEntrada.class).gimme(PedidoEntradaTemplate.PEDIDO_TEMPLATE_INVALIDO_FREE);
        UsuarioEntity usuarioEntity = Fixture.from(UsuarioEntity.class).gimme(UsuarioEntityTemplate.USUARIO_TEMPLATE_VALIDO_PREMIUM);

        //when
        pedidoFacade.preencherListaProdutos(pedidoEntrada, usuarioEntity);
    }
}
