package br.iesp.edu.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Entity
public class Login {
    @Id
    @NotEmpty
    @Column(unique = true)
    private String email;
    @NotEmpty
    private String senha;
    private boolean admin;

}
