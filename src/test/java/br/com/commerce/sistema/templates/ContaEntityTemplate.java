package br.com.commerce.sistema.templates;

import br.com.commerce.sistema.conta.model.ContaEntity;
import br.com.commerce.sistema.conta.model.ContaEntrada;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import java.util.ArrayList;
import java.util.List;

public class ContaEntityTemplate implements TemplateLoader {

    public static final String CONTA_TEMPLATE_VALIDO = "conta template valido";
    public static final String CONTA_TEMPLATE_VALIDO_PREMIUM = "conta template valido premium";

    @Override
    public void load() {
        Fixture.of(ContaEntity.class).addTemplate(CONTA_TEMPLATE_VALIDO, new Rule() {{
            add("id", 1L);
            add("numeroConta",123456);
            add("tipoConta","FREE");
            add("status","ABERTA");
        }}).addTemplate(CONTA_TEMPLATE_VALIDO_PREMIUM, new Rule(){{
            add("id", 1L);
            add("numeroConta",1234);
            add("tipoConta","PREMIUM");
            add("status","ABERTA");
        }});
    }
}
