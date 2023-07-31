package com.example.prestibanquecbhh.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VirementDto {
    private Integer numerodecompteCrediteur;
    private Integer numeroDeCompteDebiteur;
    private Double montant;
}
