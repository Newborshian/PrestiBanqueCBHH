package com.example.prestibanquecbhh.entities;

public class CompteCourant extends CompteBancaire{

    private String card;

    private final Integer OVERDRAFT;

    public CompteCourant(Integer numeroDeCompte, String typeDeCompte, Double solde) {
        super(numeroDeCompte, typeDeCompte, solde);
        this.OVERDRAFT = 1000;
    }
}
