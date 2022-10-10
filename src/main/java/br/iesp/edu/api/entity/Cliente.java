package br.iesp.edu.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Getter
@Setter
@Entity
public class Cliente {
    @Id
    @GeneratedValue
    private Integer id;
    private String nome;
    private String bairro;
    private String rua;
    private String cartao;
    private String cep;
    private String documento;
    private String dataDENascimento;
    private String benefuicios ;
    private String assinatura;

}
