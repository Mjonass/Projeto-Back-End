package br.iesp.edu.api.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Cadastro {

    @Id
    @GeneratedValue
    private Integer id;
    private String nomecompleto;
    private String dataNascimento;
    private String numeroCartao;
    private String validadeCartao;
    private int codigoSegurança;
    private String nomeDotitularDOcartao;
    private String cpfCnpj;
    private String senha;
    private String confirmarsenha;
    @Column(unique = true)
    private String email;
}
