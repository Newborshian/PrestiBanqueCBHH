package com.example.prestibanquecbhh.services;

import com.example.prestibanquecbhh.dtos.CompteBancaireDto;
import com.example.prestibanquecbhh.models.CreateCompteBancaireModel;
import com.example.prestibanquecbhh.models.VirementModel;
import com.example.prestibanquecbhh.entities.CompteCourant;
import com.example.prestibanquecbhh.entities.CompteEpargne;

import java.util.List;

public interface CompteBancaireServices {

    CompteBancaireDto toDto(CompteCourant compteCourant);
    CompteBancaireDto toDto(CompteEpargne compteEpargne);
    CompteBancaireDto createBankAccount(CreateCompteBancaireModel createCompteBancaireModel);
    void deletedBankAccount(Integer typeDeCompte, Integer id);
    List<CompteBancaireDto> getAllCompteBancaire();
    List<CompteBancaireDto> bankAccountNegativePay();

    String virement(VirementModel virementModel);

}
