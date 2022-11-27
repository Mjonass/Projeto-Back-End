package br.iesp.edu.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Entity
public class ListaFavoritos {
    @Id
    @GeneratedValue
    private Integer id;
    @OneToMany
    @JoinColumn(name ="Entreterimento")
    private List<Entreterimento> entreterimento;



}
