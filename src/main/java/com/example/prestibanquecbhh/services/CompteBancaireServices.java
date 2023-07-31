package com.example.prestibanquecbhh.services;

import com.example.prestibanquecbhh.dtos.CompteBancaireDto;
import com.example.prestibanquecbhh.dtos.CreateCompteBancaireDto;
import com.example.prestibanquecbhh.dtos.VirementDto;
import com.example.prestibanquecbhh.entities.CompteCourant;
import com.example.prestibanquecbhh.entities.CompteEpargne;

import java.util.List;

public interface CompteBancaireServices {

    CompteBancaireDto toDto(CompteCourant compteCourant);
    CompteBancaireDto toDto(CompteEpargne compteEpargne);
    CompteBancaireDto createBankAccount(CreateCompteBancaireDto createCompteBancaireDto);
    void deletedBankAccount(Integer typeDeCompte, Integer id);
    List<CompteBancaireDto> getAllCompteBancaire();
    List<CompteBancaireDto> bankAccountNegativePay();

    String virement(VirementDto virementDto);

}
