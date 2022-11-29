package br.iesp.edu.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
public class Entreterimento {
    @Id
    @GeneratedValue
    private Integer id;
    @NotNull
    private String tipo;
    @NotNull
    private String titulo;
    @NotNull
    private String genero;
    @NotNull
    private String ano;
    @NotNull
    private String duracao;
    private String relevancia;
    @NotNull
    private String sinopse;
    @NotNull
    private String trailer;


}
