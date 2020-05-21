package br.com.commerce.sistema.usuario.mapper;

import br.com.commerce.sistema.conta.model.ContaEntity;
import br.com.commerce.sistema.produto.model.ProdutoEntity;
import br.com.commerce.sistema.produto.model.ProdutoEntrada;
import br.com.commerce.sistema.templates.ContaEntityTemplate;
import br.com.commerce.sistema.templates.ProdutoEntradaTemplate;
import br.com.commerce.sistema.templates.UsuarioEntityTemplate;
import br.com.commerce.sistema.templates.UsuarioEntradaTemplate;
import br.com.commerce.sistema.usuario.model.UsuarioEntity;
import br.com.commerce.sistema.usuario.model.UsuarioEntrada;
import br.com.commerce.sistema.usuario.model.UsuarioSaida;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioMapperTest {

    private UsuarioMapper usuarioMapper = Mappers.getMapper(UsuarioMapper.class);

    @Before
    public void setup(){
        FixtureFactoryLoader.loadTemplates("br.com.commerce.sistema.templates");
    }

    @Test
    public void deveConverterEntradaParaEntity(){
        //given
        UsuarioEntrada usuarioEntrada = Fixture.from(UsuarioEntrada.class).gimme(UsuarioEntradaTemplate.USARIO_TEMPLATE_VALIDO);
        ContaEntity contaEntity = Fixture.from(ContaEntity.class).gimme(ContaEntityTemplate.CONTA_TEMPLATE_VALIDO);
        List<ContaEntity> listaContas = new ArrayList<>();
        listaContas.add(contaEntity);

        //when
        UsuarioEntity usuarioEntity = usuarioMapper.converterEntradaParaEntity(usuarioEntrada, listaContas);

        //then
        Assert.assertEquals(usuarioEntrada.getNome(), usuarioEntity.getNome());
        Assert.assertEquals(usuarioEntrada.getIdade(), usuarioEntity.getIdade());
        Assert.assertEquals(listaContas.get(0).getNumeroConta(), usuarioEntity.getListaContas().get(0).getNumeroConta());
        Assert.assertEquals(listaContas.get(0).getTipoConta(), usuarioEntity.getListaContas().get(0).getTipoConta());
        Assert.assertEquals(listaContas.get(0).getStatus(), usuarioEntity.getListaContas().get(0).getStatus());
    }

    @Test
    public void deveConverterEntityParaSaida(){
        //given
        UsuarioEntity usuarioEntity = Fixture.from(UsuarioEntity.class).gimme(UsuarioEntityTemplate.USUARIO_TEMPLATE_VALIDO);

        //when
        UsuarioSaida usuarioSaida = usuarioMapper.converterEntityParaSaida(usuarioEntity);

        //then
        Assert.assertEquals(usuarioEntity.getNome(), usuarioSaida.getNome());
        Assert.assertEquals(usuarioEntity.getIdade(), usuarioSaida.getIdade());
        Assert.assertEquals(usuarioEntity.getListaContas().get(0).getNumeroConta(), usuarioSaida.getListaContas().get(0).getNumeroConta());
        Assert.assertEquals(usuarioEntity.getListaContas().get(0).getTipoConta(), usuarioSaida.getListaContas().get(0).getTipoConta());
        Assert.assertEquals(usuarioEntity.getListaContas().get(0).getStatus(), usuarioSaida.getListaContas().get(0).getStatus());
    }
}
