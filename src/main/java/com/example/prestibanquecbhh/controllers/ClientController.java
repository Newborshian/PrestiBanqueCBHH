package com.example.prestibanquecbhh.controllers;

import com.example.prestibanquecbhh.dtos.ClientDto;
import com.example.prestibanquecbhh.entities.Client;
import com.example.prestibanquecbhh.services.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("client")
public class ClientController {
    @Autowired
    private ClientServices clientServices;
    @GetMapping
    public ResponseEntity<List<Client>> getAllClient(){
        try {
            return new ResponseEntity<>(clientServices.getAllClient(), HttpStatus.OK);
        } catch (RuntimeException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<Client> postClient(@RequestBody ClientDto client){
        try {
            return new ResponseEntity<>(clientServices.saveClient(client), HttpStatus.OK);
        } catch (RuntimeException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Integer id, @RequestBody ClientDto client){
        try {
            return new ResponseEntity<>(clientServices.updateClient(id, client), HttpStatus.OK);
        } catch (RuntimeException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Integer id){
        try {
            clientServices.deleteClient(id);
            return new ResponseEntity<>("Le client a été supprimé avec succès", HttpStatus.OK);
        } catch (RuntimeException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
}
