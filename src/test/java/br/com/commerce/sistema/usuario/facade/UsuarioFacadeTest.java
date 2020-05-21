package br.com.commerce.sistema.usuario.facade;

import br.com.commerce.sistema.conta.model.ContaEntity;
import br.com.commerce.sistema.conta.repository.ContaRepository;
import br.com.commerce.sistema.templates.ContaEntityTemplate;
import br.com.commerce.sistema.templates.UsuarioEntityTemplate;
import br.com.commerce.sistema.templates.UsuarioEntradaTemplate;
import br.com.commerce.sistema.usuario.model.UsuarioEntity;
import br.com.commerce.sistema.usuario.model.UsuarioEntrada;
import br.com.commerce.sistema.usuario.model.UsuarioSaida;
import br.com.commerce.sistema.usuario.repository.UsuarioRepository;
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

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioFacadeTest {

    @InjectMocks
    UsuarioFacade usuarioFacade;

    @Mock
    ContaRepository contaRepository;
    @Mock
    UsuarioRepository usuarioRepository;

    @Before
    public void setup(){
        FixtureFactoryLoader.loadTemplates("br.com.commerce.sistema.templates");
    };

    @Test
    public void deveCriarUsuario() throws Exception {
        //given
        UsuarioEntrada usuarioEntrada = Fixture.from(UsuarioEntrada.class).gimme(UsuarioEntradaTemplate.USARIO_TEMPLATE_VALIDO);
        ContaEntity contaEntity = Fixture.from(ContaEntity.class).gimme(ContaEntityTemplate.CONTA_TEMPLATE_VALIDO);
        UsuarioEntity usuarioEntity = Fixture.from(UsuarioEntity.class).gimme(UsuarioEntityTemplate.USUARIO_TEMPLATE_VALIDO);
        List<ContaEntity> listaContaEntity = new ArrayList<>();
        listaContaEntity.add(contaEntity);
        Mockito.when(contaRepository.findByStatus(Mockito.anyString())).thenReturn(listaContaEntity);
        Mockito.when(usuarioRepository.save(Mockito.anyObject())).thenReturn(usuarioEntity);

        //when
        UsuarioSaida usuarioSaida = usuarioFacade.criarUsuario(usuarioEntrada);

        //then
        Assert.assertNotNull(usuarioSaida);
    }

    @Test
    public void deveRetornarUsuarioEntity() throws Exception {
        //given
        Long id = 1L;
        UsuarioEntity usuarioEntity = Fixture.from(UsuarioEntity.class).gimme(UsuarioEntityTemplate.USUARIO_TEMPLATE_VALIDO);
        Mockito.when(usuarioRepository.findById(Mockito.anyLong())).thenReturn(java.util.Optional.ofNullable(usuarioEntity));

        //when
        UsuarioEntity saida = usuarioFacade.retornarUsuarioEntity(id);

        //then
        Assert.assertNotNull(saida);
    }

    @Test(expected = java.lang.Exception.class)
    public void deveGerarErroRetornoUsuarioEntityEmpity() throws Exception {
        //given
        Long id = 1L;

        //when
        usuarioFacade.retornarUsuarioEntity(id);
    }
}
