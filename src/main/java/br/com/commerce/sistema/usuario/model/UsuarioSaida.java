package br.com.commerce.sistema.usuario.model;

import br.com.commerce.sistema.conta.model.ContaSaida;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioSaida {

    private Long id;
    private String nome;
    private Integer idade;
    private List<ContaSaida> listaContas;
}
