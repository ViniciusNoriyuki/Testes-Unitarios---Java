package br.com.commerce.sistema.conta.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContaSaida {

    private Long id;
    private Integer numeroConta;
    private String tipoConta;
    private String status;
}
