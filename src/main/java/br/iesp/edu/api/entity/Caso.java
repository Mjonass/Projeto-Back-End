package br.iesp.edu.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Caso {
    @Id
    @GeneratedValue
    private Integer id;
    private String nome;
    private String tipo;
    private String descricao ;
    private String cliente;
}
