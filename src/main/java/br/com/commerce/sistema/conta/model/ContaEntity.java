package br.com.commerce.sistema.conta.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Conta")
public class ContaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "numeroConta")
    Integer numeroConta;

    @Column(name = "tipoConta")
    String tipoConta;

    @Column(name = "status")
    String status;
}
