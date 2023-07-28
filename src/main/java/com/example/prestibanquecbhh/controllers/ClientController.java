package com.example.prestibanquecbhh.controllers;

import com.example.prestibanquecbhh.dtos.ClientDto;
import com.example.prestibanquecbhh.entities.Client;
import com.example.prestibanquecbhh.services.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("client")
public class ClientController {
    @Autowired
    private ClientServices clientServices;
    @GetMapping
    public List<Client> getAllClient(){
        return clientServices.getAllClient();
    }

    @PostMapping
    public Client postClient(@RequestBody ClientDto client){
        return clientServices.saveClient(client);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Integer id, @RequestBody ClientDto client){
        try {
            return new ResponseEntity<>(clientServices.updateClient(id, client), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Integer id){
        clientServices.deleteClient(id);
    }
}
