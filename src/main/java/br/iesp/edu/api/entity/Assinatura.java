package br.iesp.edu.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Assinatura {

    @Id
    @GeneratedValue
    private Integer id;
    private String nome;
    private Double preco;
    private String tipo;
    private String beneficios;

}
