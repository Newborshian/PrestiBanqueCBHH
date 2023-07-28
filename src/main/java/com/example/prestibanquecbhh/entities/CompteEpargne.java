package com.example.prestibanquecbhh.entities;

public class CompteEpargne extends CompteBancaire{

    private final Double tauxInteret;

    public CompteEpargne(Integer numeroDeCompte, String typeDeCompte, Double solde) {
        super(numeroDeCompte, typeDeCompte, solde);
        this.tauxInteret = 0.3;
    }
}
