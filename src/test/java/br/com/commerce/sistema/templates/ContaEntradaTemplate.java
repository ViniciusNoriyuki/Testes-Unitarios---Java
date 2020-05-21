package br.com.commerce.sistema.templates;

import br.com.commerce.sistema.conta.model.ContaEntrada;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class ContaEntradaTemplate implements TemplateLoader {

    public static final String CONTA_TEMPLATE_VALIDO = "conta template valido";

    @Override
    public void load() {
        Fixture.of(ContaEntrada.class).addTemplate(CONTA_TEMPLATE_VALIDO, new Rule() {{
            add("numeroConta",123456);
            add("tipoConta","Free");
        }});
    }
}
