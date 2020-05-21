package br.com.commerce.sistema.templates;

import br.com.commerce.sistema.usuario.model.UsuarioEntrada;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class UsuarioEntradaTemplate implements TemplateLoader {

    public static final String USARIO_TEMPLATE_VALIDO = "usuario template valido";

    @Override
    public void load() {
        Fixture.of(UsuarioEntrada.class).addTemplate(USARIO_TEMPLATE_VALIDO, new Rule() {{
            add("nome","Vinicius");
            add("idade",25);
        }});
    }
}
