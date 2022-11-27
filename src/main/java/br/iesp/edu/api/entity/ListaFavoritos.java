package br.iesp.edu.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class ListaFavoritos {
    @Id
    @GeneratedValue
    private Integer id;
    @OneToMany
    @JoinColumn(name ="ListaFavoritos")
    private Entreterimento entreterimento;

}
