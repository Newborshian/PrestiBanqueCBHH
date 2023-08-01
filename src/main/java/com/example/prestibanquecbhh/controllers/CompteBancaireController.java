package com.example.prestibanquecbhh.controllers;

import com.example.prestibanquecbhh.dtos.CompteBancaireDto;
import com.example.prestibanquecbhh.models.CreateCompteBancaireModel;
import com.example.prestibanquecbhh.models.VirementModel;
import com.example.prestibanquecbhh.services.CompteBancaireServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("compteBancaire")
public class CompteBancaireController {

    @Autowired
    private CompteBancaireServices compteBancaireServices;

    @PostMapping
    public ResponseEntity<CompteBancaireDto> creerCompteBancaire(@RequestBody CreateCompteBancaireModel createCompteBancaireModel){
        try {
            CompteBancaireDto compteBancaireDto = compteBancaireServices.createBankAccount(createCompteBancaireModel);
            return new ResponseEntity(compteBancaireDto, HttpStatus.OK);
        } catch (RuntimeException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{typeDeCompte}/{id}")
    public ResponseEntity<String> deleteCompteBancaire(@PathVariable Integer typeDeCompte, @PathVariable Integer id){
        try {
            compteBancaireServices.deletedBankAccount(typeDeCompte, id);
            return new ResponseEntity<>("Le compte bancaire a bien été supprimé", HttpStatus.OK);

        } catch (RuntimeException e){
           return new ResponseEntity( e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<CompteBancaireDto>> getAllCompteBancaire(){
        try {
            return new ResponseEntity<>(compteBancaireServices.getAllCompteBancaire(), HttpStatus.OK);
        } catch (RuntimeException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/negatif")
    public ResponseEntity<List<CompteBancaireDto>> getCompteBancaireNegatif(){
        try {
            return new ResponseEntity<>(compteBancaireServices.bankAccountNegativePay(), HttpStatus.OK);
        } catch (RuntimeException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/virement")
    public ResponseEntity<String> virement(@RequestBody VirementModel virementModel){
        try {
            return new ResponseEntity<>(compteBancaireServices.virement(virementModel), HttpStatus.OK);
        } catch (RuntimeException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}




