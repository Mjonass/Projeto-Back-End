package br.iesp.edu.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Perfil {
    @Id
    @GeneratedValue
    private Integer id;
    private String nome;
    private String tipo;
    private String cliente;
}
