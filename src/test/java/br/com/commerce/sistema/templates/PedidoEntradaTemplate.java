package br.com.commerce.sistema.templates;

import br.com.commerce.sistema.pedido.model.PedidoEntrada;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import java.util.ArrayList;
import java.util.List;

public class PedidoEntradaTemplate implements TemplateLoader {

    public static final String PEDIDO_TEMPLATE_VALIDO = "pedido template valido";
    public static final String PEDIDO_TEMPLATE_INVALIDO_FREE = "pedido template valido free";

    @Override
    public void load() {
        Fixture.of(PedidoEntrada.class).addTemplate(PEDIDO_TEMPLATE_VALIDO, new Rule(){{
            List<Long> lista = new ArrayList<Long>(){{add(1L);}};
            add("usuario", 1L);
            add("listaProduto", lista);
        }}).addTemplate(PEDIDO_TEMPLATE_INVALIDO_FREE, new Rule(){{
            List<Long> lista = new ArrayList<Long>(){{
                add(1L);
                add(2L);
                add(3L);
                add(4L);
            }};
            add("usuario", 1L);
            add("listaProduto", lista);
        }});
    }
}
