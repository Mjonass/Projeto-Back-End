package br.iesp.edu.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
public class Caso {
    @Id
    @GeneratedValue
    private Integer id;
    @NotNull
    private String nome;
    @NotNull
    private String tipo;
    @NotNull
    private String descricao ;
    @NotNull
    private String cliente;
}
