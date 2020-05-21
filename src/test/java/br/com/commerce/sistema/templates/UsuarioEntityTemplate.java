package br.com.commerce.sistema.templates;

import br.com.commerce.sistema.conta.model.ContaEntity;
import br.com.commerce.sistema.usuario.model.UsuarioEntity;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import java.util.ArrayList;
import java.util.List;

public class UsuarioEntityTemplate implements TemplateLoader {

    public static final String USUARIO_TEMPLATE_VALIDO = "usuario template valido";
    public static final String USUARIO_TEMPLATE_VALIDO_PREMIUM = "usuario template valido premium";

    @Override
    public void load() {
        Fixture.of(UsuarioEntity.class).addTemplate(USUARIO_TEMPLATE_VALIDO, new Rule() {{
            add("id", 1L);
            add("nome", "Vinicius");
            add("idade", 25);
            add("listaContas", has(1).of(ContaEntity.class, ContaEntityTemplate.CONTA_TEMPLATE_VALIDO));
        }}).addTemplate(USUARIO_TEMPLATE_VALIDO_PREMIUM, new Rule(){{
            add("id", 1L);
            add("nome", "Vinicius");
            add("idade", 25);
            add("listaContas", has(1).of(ContaEntity.class, ContaEntityTemplate.CONTA_TEMPLATE_VALIDO_PREMIUM));
        }});
    }
}
