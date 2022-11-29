package br.iesp.edu.api.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Cadastro {
    @Id
    @GeneratedValue
    private Integer id;
    @NotNull
    private String nomecompleto;
    @NotNull
    @JsonFormat(pattern = "dd/mm/yy")
    private String dataNascimento;
    @NotNull
    private String numeroCartao;
    @NotNull
    @JsonFormat(pattern = "MM/YY")
    private String validadeCartao;
    @NotNull
    private int codigoSegurança;
    @NotNull
    private String nomeDotitularDocartao;
    @Column(unique = true)
    @NotNull
    @CPF
    private String cpf;
    @NotNull
    private String senha;
    @NotNull
    private String confirmarsenha;
    @NotNull
    @Column(unique = true)
    private String email;
    private boolean admin;
    @OneToOne
    @JoinColumn(name = "assinatura")
    private Assinatura assinatura;
    @OneToOne
    @JoinColumn(name ="ListaFavoritos")
    private ListaFavoritos listaFavoritos;
}
