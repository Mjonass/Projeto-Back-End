package br.iesp.edu.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
public class Assinatura {

    @Id
    @GeneratedValue
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private String preco__c;
    private String tipo__c;
    private String beneficios__c;
    @NotNull
    private String idSalesForce;

}
