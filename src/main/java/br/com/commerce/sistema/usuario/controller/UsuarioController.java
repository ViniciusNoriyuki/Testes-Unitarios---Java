package br.com.commerce.sistema.usuario.controller;

import br.com.commerce.sistema.usuario.facade.UsuarioFacade;
import br.com.commerce.sistema.usuario.model.UsuarioEntrada;
import br.com.commerce.sistema.usuario.model.UsuarioSaida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "commerce/usuario", produces = "application/json")
@Configuration
@CrossOrigin
public class UsuarioController {

    @Autowired
    UsuarioFacade usuarioFacade;

    @PostMapping
    public UsuarioSaida salvar(@RequestBody UsuarioEntrada usuarioEntrada) throws Exception {

        UsuarioSaida saida = usuarioFacade.criarUsuario(usuarioEntrada);
        return saida;
    }
}
