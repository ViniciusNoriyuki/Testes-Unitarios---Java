package br.com.commerce.sistema.templates;

import br.com.commerce.sistema.produto.model.ProdutoEntity;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class ProdutoEntityTemplate implements TemplateLoader {

    public static final String PRODUTO_TEMPLATE_VALIDO = "produto template valido";

    @Override
    public void load() {
        Fixture.of(ProdutoEntity.class).addTemplate(PRODUTO_TEMPLATE_VALIDO, new Rule() {{
            add("id", 1L);
            add("nomeProduto","Feijao");
        }});
    }
}
