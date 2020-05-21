package br.com.commerce.sistema.pedido.mapper;

import br.com.commerce.sistema.pedido.model.PedidoEntity;
import br.com.commerce.sistema.pedido.model.PedidoEntrada;
import br.com.commerce.sistema.pedido.model.PedidoSaida;
import br.com.commerce.sistema.produto.model.ProdutoEntity;
import br.com.commerce.sistema.templates.PedidoEntityTemplate;
import br.com.commerce.sistema.templates.PedidoEntradaTemplate;
import br.com.commerce.sistema.templates.ProdutoEntityTemplate;
import br.com.commerce.sistema.templates.UsuarioEntityTemplate;
import br.com.commerce.sistema.usuario.model.UsuarioEntity;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.sun.xml.bind.v2.schemagen.xmlschema.FixedOrDefault;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class PedidoMapperTest {

    private PedidoMapper pedidoMapper = Mappers.getMapper(PedidoMapper.class);

    @Before
    public void setup(){
        FixtureFactoryLoader.loadTemplates("br.com.commerce.sistema.templates");
    }

    @Test
    public void deveConverterEntradaParaEntity(){
        //given
        PedidoEntrada pedidoEntrada = Fixture.from(PedidoEntrada.class).gimme(PedidoEntradaTemplate.PEDIDO_TEMPLATE_VALIDO);
        UsuarioEntity usuarioEntity = Fixture.from(UsuarioEntity.class).gimme(UsuarioEntityTemplate.USUARIO_TEMPLATE_VALIDO);
        ProdutoEntity produtoEntity = Fixture.from(ProdutoEntity.class).gimme(ProdutoEntityTemplate.PRODUTO_TEMPLATE_VALIDO);
        List<ProdutoEntity> listaProduto = new ArrayList<>();
        listaProduto.add(produtoEntity);

        //when
        PedidoEntity pedidoEntity = pedidoMapper.converterEntradaParaEntity(pedidoEntrada, usuarioEntity, listaProduto);

        //then
        Assert.assertEquals(pedidoEntity.getUsuario().getNome(), usuarioEntity.getNome());
        Assert.assertEquals(pedidoEntity.getUsuario().getIdade(), usuarioEntity.getIdade());
        Assert.assertEquals(pedidoEntity.getUsuario().getListaContas().get(0).getNumeroConta(), usuarioEntity.getListaContas().get(0).getNumeroConta());
        Assert.assertEquals(pedidoEntity.getUsuario().getListaContas().get(0).getTipoConta(), usuarioEntity.getListaContas().get(0).getTipoConta());
        Assert.assertEquals(pedidoEntity.getUsuario().getListaContas().get(0).getStatus(), usuarioEntity.getListaContas().get(0).getStatus());
        Assert.assertEquals(pedidoEntity.getListaProduto().get(0).getNomeProduto(), listaProduto.get(0).getNomeProduto());
    }

    @Test
    public void deveConverterEntityParaSaida(){
        //given
        PedidoEntity pedidoEntity = Fixture.from(PedidoEntity.class).gimme(PedidoEntityTemplate.PEDIDO_TEMPLATE_VALIDO);

        //when
        PedidoSaida pedidoSaida = pedidoMapper.converterEntityParaSaida(pedidoEntity);

        //then
        Assert.assertEquals(pedidoEntity.getUsuario().getNome(), pedidoSaida.getUsuario().getNome());
        Assert.assertEquals(pedidoEntity.getUsuario().getIdade(), pedidoSaida.getUsuario().getIdade());
        Assert.assertEquals(pedidoEntity.getUsuario().getListaContas().get(0).getNumeroConta(), pedidoSaida.getUsuario().getListaContas().get(0).getNumeroConta());
        Assert.assertEquals(pedidoEntity.getUsuario().getListaContas().get(0).getTipoConta(), pedidoSaida.getUsuario().getListaContas().get(0).getTipoConta());
        Assert.assertEquals(pedidoEntity.getUsuario().getListaContas().get(0).getStatus(), pedidoSaida.getUsuario().getListaContas().get(0).getStatus());
        Assert.assertEquals(pedidoEntity.getListaProduto().get(0).getNomeProduto(), pedidoSaida.getListaProduto().get(0).getNomeProduto());
    }
}
