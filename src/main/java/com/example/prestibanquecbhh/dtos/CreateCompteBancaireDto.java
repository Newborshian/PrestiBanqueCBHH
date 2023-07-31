package com.example.prestibanquecbhh.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCompteBancaireDto {

    private Integer numerodecompte;
    private Boolean isEpargne;
    private Double overDraft;
    private Double tauxInteret;
    private String card;
    private Double solde;
    private String createdat;
    private Integer id_client;

}
