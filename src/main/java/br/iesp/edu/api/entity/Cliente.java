package br.iesp.edu.api.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;


@Getter
@Setter
@Entity
public class Cliente {
    @Id
    @GeneratedValue
    private Integer id;
    private String nome;
    private String bairro;
    private String rua;
    private String cartao;
    private String cep;
    private String documento;
    @JsonFormat(pattern = "dd/mm/yy")
    private LocalDate dataDENascimento;
    private String benefuicios ;
    private String assinatura;

}
