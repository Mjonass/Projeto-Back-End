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
    private String Título;
    private String Gênero;
    private String Ano;
    private String Duração;
    private String Relevância;
    private String Sinopse;
    private String Trailer;

}
