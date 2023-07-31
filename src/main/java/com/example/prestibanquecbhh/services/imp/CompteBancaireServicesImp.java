package com.example.prestibanquecbhh.services.imp;

import com.example.prestibanquecbhh.dtos.CompteBancaireDto;
import com.example.prestibanquecbhh.models.CreateCompteBancaireModel;
import com.example.prestibanquecbhh.models.VirementModel;
import com.example.prestibanquecbhh.entities.CompteCourant;
import com.example.prestibanquecbhh.entities.CompteEpargne;
import com.example.prestibanquecbhh.enums.TypeDeCompte;
import com.example.prestibanquecbhh.repositories.ClientRepository;
import com.example.prestibanquecbhh.repositories.CompteCourantRepository;
import com.example.prestibanquecbhh.repositories.CompteEpargneRepository;
import com.example.prestibanquecbhh.services.CompteBancaireServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompteBancaireServicesImp implements CompteBancaireServices {

    @Autowired
    private CompteEpargneRepository compteEpargneRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CompteCourantRepository compteCourantRepository;

    @Override
    public CompteBancaireDto toDto(CompteCourant compteCourant) {
        CompteBancaireDto compteBancaireDto = new CompteBancaireDto();
        compteBancaireDto.setId(compteCourant.getId());
        compteBancaireDto.setNumerodecompte(compteCourant.getNumerodecompte());
        compteBancaireDto.setTypeDeCompte(TypeDeCompte.COURANT.toString());
        compteBancaireDto.setSolde(compteCourant.getSolde());
        compteBancaireDto.setOverDraft(compteCourant.getOverdraft());
        compteBancaireDto.setNameClient(compteCourant.getClient().getLastname() + " " + compteCourant.getClient().getFirstname());
        return compteBancaireDto;
    }

    @Override
    public CompteBancaireDto toDto(CompteEpargne compteEpargne) {
        CompteBancaireDto compteBancaireDto = new CompteBancaireDto();
        compteBancaireDto.setId(compteEpargne.getId());
        compteBancaireDto.setNumerodecompte(compteEpargne.getNumerodecompte());
        compteBancaireDto.setTypeDeCompte(TypeDeCompte.EPARGNE.toString());
        compteBancaireDto.setSolde(compteEpargne.getSolde());
        compteBancaireDto.setTauxInteret(compteEpargne.getTauxInteret());
        compteBancaireDto.setNameClient(compteEpargne.getClient().getLastname() + " " + compteEpargne.getClient().getFirstname());
        return compteBancaireDto;
    }

    @Override
    public CompteBancaireDto createBankAccount(CreateCompteBancaireModel createCompteBancaireModel) {
        if (!createCompteBancaireModel.getIsEpargne()){
          CompteCourant compteCourant = new CompteCourant();
          compteCourant.setNumerodecompte(createCompteBancaireModel.getNumerodecompte());
          compteCourant.setSolde(createCompteBancaireModel.getSolde());
          compteCourant.setCreatedat(createCompteBancaireModel.getCreatedat());
          compteCourant.setClient(clientRepository.findById(createCompteBancaireModel.getId_client()).get());
          compteCourant.setCard(createCompteBancaireModel.getCard());
          compteCourant.setOverdraft(createCompteBancaireModel.getOverDraft());
          compteCourantRepository.save(compteCourant);
          return toDto(compteCourant);

        } else {
            CompteEpargne compteEpargne = new CompteEpargne();
            compteEpargne.setNumerodecompte(createCompteBancaireModel.getNumerodecompte());
            compteEpargne.setSolde(createCompteBancaireModel.getSolde());
            compteEpargne.setCreatedat(createCompteBancaireModel.getCreatedat());
            compteEpargne.setClient(clientRepository.findById(createCompteBancaireModel.getId_client()).get());
            compteEpargne.setTauxInteret(createCompteBancaireModel.getTauxInteret());
            compteEpargneRepository.save(compteEpargne);
            return toDto(compteEpargne);
        }

    }

    @Override
    public void deletedBankAccount(Integer typeDeCompte, Integer id) {
        if (typeDeCompte == 1){
            compteEpargneRepository.deleteById(id);
        } else if (typeDeCompte == 2){
            compteCourantRepository.deleteById(id);
        }
    }

    @Override
    public List<CompteBancaireDto> bankAccountNegativePay() {
       List<CompteCourant> compteCourantList = compteCourantRepository.findAllBySoldeLessThan(0);
       List<CompteBancaireDto> compteBancaireDtoList = new ArrayList<>();
       for (CompteCourant compteCourant : compteCourantList){
           compteBancaireDtoList.add(toDto(compteCourant));
       }
       return compteBancaireDtoList;
    }

    @Override
    public List<CompteBancaireDto> getAllCompteBancaire() {

        List<CompteBancaireDto> compteBancaireDtoList = new ArrayList<>();
        List<CompteCourant> compteCourantList = compteCourantRepository.findAll();
        List<CompteEpargne> compteEpargneList = compteEpargneRepository.findAll();
        for (CompteCourant compteCourant : compteCourantList){
            compteBancaireDtoList.add(toDto(compteCourant));
        }
        for (CompteEpargne compteEpargne : compteEpargneList){
            compteBancaireDtoList.add(toDto(compteEpargne));
        }
        return compteBancaireDtoList;

    }

    @Override
    public String virement(VirementModel virementModel) {
        CompteCourant compteCourantCrediteur = compteCourantRepository.findByNumerodecompte(virementModel.getNumerodecompteCrediteur());
        CompteCourant compteCourantDebiteur = compteCourantRepository.findByNumerodecompte(virementModel.getNumeroDeCompteDebiteur());

        if ( compteCourantCrediteur.getSolde() + compteCourantCrediteur.getOverdraft() >= virementModel.getMontant()) {
            compteCourantCrediteur.setSolde(compteCourantCrediteur.getSolde() - virementModel.getMontant());
            compteCourantDebiteur.setSolde(compteCourantDebiteur.getSolde() + virementModel.getMontant());
            compteCourantRepository.save(compteCourantCrediteur);
            compteCourantRepository.save(compteCourantDebiteur);
            return "Virement effectué" + compteCourantCrediteur.getSolde() + " " + compteCourantDebiteur.getSolde() ;
        }
        return "Virement impossible :'(";
    }
}
