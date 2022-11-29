package br.iesp.edu.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
public class Perfil {
    @Id
    @GeneratedValue
    private Integer id;
    @NotNull
    private String nome;
    @NotNull
    private String tipo;
    @OneToOne
    @JoinColumn(name = "Cadastro")
    private Cadastro cadastro;
}
