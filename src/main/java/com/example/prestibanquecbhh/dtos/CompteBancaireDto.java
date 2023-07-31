package com.example.prestibanquecbhh.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompteBancaireDto {
    private Integer id;
    private Integer numerodecompte;
    private String nameClient;
    private String typeDeCompte;
    private Double overDraft;
    private Double tauxInteret;
    private Double solde;
}
