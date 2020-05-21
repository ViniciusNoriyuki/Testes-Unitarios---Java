package br.com.commerce.sistema.produto.controller;

import br.com.commerce.sistema.produto.facade.ProdutoFacade;
import br.com.commerce.sistema.produto.model.ProdutoEntrada;
import br.com.commerce.sistema.produto.model.ProdutoSaida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "commerce/produto", produces = "application/json")
@Configuration
@CrossOrigin
public class ProdutoController {

    @Autowired
    public ProdutoFacade produtoFacade;

    @PostMapping
    public ProdutoSaida salvar(@RequestBody ProdutoEntrada produtoEntrada) throws Exception {

        ProdutoSaida saida = produtoFacade.criarProduto(produtoEntrada);
        return saida;
    }
}
