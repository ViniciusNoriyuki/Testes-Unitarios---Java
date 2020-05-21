package br.com.commerce.sistema.pedido.controller;

import br.com.commerce.sistema.pedido.facade.PedidoFacade;
import br.com.commerce.sistema.pedido.model.PedidoEntrada;
import br.com.commerce.sistema.pedido.model.PedidoSaida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "commerce/pedido", produces = "application/json")
@Configuration
@CrossOrigin
public class PedidoController {

    @Autowired
    PedidoFacade pedidoFacade;

    @PostMapping
    public PedidoSaida salvar(@RequestBody PedidoEntrada pedidoEntrada) throws Exception {

        PedidoSaida saida = pedidoFacade.criarPedido(pedidoEntrada);
        return saida;
    }
}
