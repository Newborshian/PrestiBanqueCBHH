package com.example.prestibanquecbhh.controllers;

import com.example.prestibanquecbhh.dtos.ConseillerDto;
import com.example.prestibanquecbhh.entities.Conseiller;
import com.example.prestibanquecbhh.services.ConseillerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("conseiller")
public class ConseillerController {

    @Autowired
    ConseillerServices conseillerServices;

    @GetMapping
    public ResponseEntity<List<ConseillerDto>> getAllClientByConseiller(){
        try {
            return new ResponseEntity<>(conseillerServices.getAllConseiller(), HttpStatus.OK);
        } catch (RuntimeException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<Conseiller> createConseiller(@RequestBody ConseillerDto conseillerDto){
        try {
            return new ResponseEntity<>(conseillerServices.saveConseiller(conseillerDto), HttpStatus.OK);
        } catch (RuntimeException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteConseiller(@PathVariable Integer id){
        try {
            conseillerServices.deleteConseiller(id);
            return new ResponseEntity<>("Conseillé Supprimé avec succès", HttpStatus.OK);
        } catch (RuntimeException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Conseiller> updateConseiller(@PathVariable Integer id, @RequestBody ConseillerDto conseillerDto){
        try {
            return new ResponseEntity<>(conseillerServices.updateConseiller(id, conseillerDto), HttpStatus.OK);
        } catch (RuntimeException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
