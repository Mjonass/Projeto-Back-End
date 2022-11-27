package br.iesp.edu.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Entreterimento {
    @Id
    @GeneratedValue
    private Integer id;
    private String tipo;
    private String titulo;
    private String genero;
    private String ano;
    private String duracao;
    private String relevancia;
    private String sinopse;
    private String trailer;


}
