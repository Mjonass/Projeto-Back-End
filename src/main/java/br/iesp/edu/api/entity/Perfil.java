package br.iesp.edu.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Perfil {
    @Id
    @GeneratedValue
    private Integer id;
    private String nome;
    private String tipo;
    //@OneToOne
    //@JoinColumn(name ="Cliente")
    private String cliente;
}
