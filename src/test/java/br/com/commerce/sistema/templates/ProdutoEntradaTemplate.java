package br.com.commerce.sistema.templates;

import br.com.commerce.sistema.produto.model.ProdutoEntrada;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class ProdutoEntradaTemplate implements TemplateLoader {

    public static final String PRODUTO_TEMPLATE_VALIDO = "produto template valido";

    @Override
    public void load() {
        Fixture.of(ProdutoEntrada.class).addTemplate(PRODUTO_TEMPLATE_VALIDO, new Rule() {{
            add("nomeProduto","Feijao");
        }});
    }
}
