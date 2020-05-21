package br.com.commerce.sistema.conta.controller;

import br.com.commerce.sistema.conta.facade.ContaFacade;
import br.com.commerce.sistema.conta.model.ContaEntrada;
import br.com.commerce.sistema.conta.model.ContaSaida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "commerce/conta", produces = "application/json")
@Configuration
@CrossOrigin
public class ContaController {

    @Autowired
    ContaFacade contaFacade;

    @PostMapping
    public ContaSaida salvar(@RequestBody ContaEntrada contaEntrada) throws Exception {

        ContaSaida saida = contaFacade.criarConta(contaEntrada);
        return saida;
    }
}
