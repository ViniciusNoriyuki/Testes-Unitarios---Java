package br.com.commerce.sistema.conta.facade;

import br.com.commerce.sistema.conta.model.ContaEntity;
import br.com.commerce.sistema.conta.model.ContaEntrada;
import br.com.commerce.sistema.conta.model.ContaSaida;
import br.com.commerce.sistema.conta.repository.ContaRepository;
import br.com.commerce.sistema.templates.ContaEntityTemplate;
import br.com.commerce.sistema.templates.ContaEntradaTemplate;
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
public class ContaFacadeTest {

    @InjectMocks
    ContaFacade contaFacade;

    @Mock
    ContaRepository contaRepository;

    @Before
    public void setup(){
        FixtureFactoryLoader.loadTemplates("br.com.commerce.sistema.templates");
    };

    @Test
    public void deveCriarConta() throws Exception {
        //given
        ContaEntrada contaEntrada = Fixture.from(ContaEntrada.class).gimme(ContaEntradaTemplate.CONTA_TEMPLATE_VALIDO);
        ContaEntity contaEntity = Fixture.from(ContaEntity.class).gimme(ContaEntityTemplate.CONTA_TEMPLATE_VALIDO);
        Mockito.when(contaRepository.save(Mockito.anyObject())).thenReturn(contaEntity);

        //when
        ContaSaida contaSaida = contaFacade.criarConta(contaEntrada);

        //then
        Assert.assertNotNull(contaEntity);
    }
}
