package br.com.commerce.sistema.templates;

import br.com.commerce.sistema.pedido.model.PedidoEntity;
import br.com.commerce.sistema.produto.model.ProdutoEntity;
import br.com.commerce.sistema.usuario.model.UsuarioEntity;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class PedidoEntityTemplate implements TemplateLoader {

    public static final String PEDIDO_TEMPLATE_VALIDO = "pedido template valido";

    @Override
    public void load() {
        Fixture.of(PedidoEntity.class).addTemplate(PEDIDO_TEMPLATE_VALIDO, new Rule(){{
            add("id", 1L);
            add("usuario", one(UsuarioEntity.class, UsuarioEntityTemplate.USUARIO_TEMPLATE_VALIDO));
            add("listaProduto", has(1).of(ProdutoEntity.class, ProdutoEntityTemplate.PRODUTO_TEMPLATE_VALIDO));
        }});
    }
}
