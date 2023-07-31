package com.example.prestibanquecbhh.controllers;

import com.example.prestibanquecbhh.dtos.CompteBancaireDto;
import com.example.prestibanquecbhh.dtos.CreateCompteBancaireDto;
import com.example.prestibanquecbhh.dtos.VirementDto;
import com.example.prestibanquecbhh.entities.CompteCourant;
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
    public ResponseEntity<CompteBancaireDto> creerCompteBancaire(@RequestBody CreateCompteBancaireDto createCompteBancaireDto){
        try {
            CompteBancaireDto compteBancaireDto = compteBancaireServices.createBankAccount(createCompteBancaireDto);
            return new ResponseEntity(compteBancaireDto, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{typeDeCompte}/{id}")
    public void deleteCompteBancaire(@PathVariable Integer typeDeCompte, @PathVariable Integer id){
        try {
            compteBancaireServices.deletedBankAccount(typeDeCompte, id);

        } catch (Exception e){
            e.getMessage();
        }
    }

    @GetMapping
    public ResponseEntity<List<CompteBancaireDto>> getAllCompteBancaire(){
        try {
            return new ResponseEntity<>(compteBancaireServices.getAllCompteBancaire(), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/negatif")
    public ResponseEntity<List<CompteBancaireDto>> getCompteBancaireNegatif(){
        try {
            return new ResponseEntity<>(compteBancaireServices.bankAccountNegativePay(), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/virement")
    public ResponseEntity<String> virement(@RequestBody VirementDto virementDto){
        try {
            return new ResponseEntity<>(compteBancaireServices.virement(virementDto), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    }




