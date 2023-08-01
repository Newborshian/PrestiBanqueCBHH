package com.example.prestibanquecbhh.services.imp;

import com.example.prestibanquecbhh.dtos.ClientDto;
import com.example.prestibanquecbhh.entities.Client;
import com.example.prestibanquecbhh.entities.Conseiller;
import com.example.prestibanquecbhh.repositories.ClientRepository;
import com.example.prestibanquecbhh.repositories.ConseillerRepository;
import com.example.prestibanquecbhh.services.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServicesImp implements ClientServices {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ConseillerRepository conseillerRepository;

    @Override
    public List<Client> getAllClient() {
        List<Client> clients = clientRepository.findAll();
        if (clients.isEmpty()) {
            throw new RuntimeException("Tu es une mauvaise entreprise ta aucun client ! Bouh");
        }
        return clients;
    }

    @Override
    public Client saveClient(ClientDto client) {
        Client newClient = new Client();
        newClient.setLastname(client.getLastname());
        newClient.setFirstname(client.getFirstname());
        newClient.setCity(client.getCity());
        newClient.setAddress(client.getAddress());
        newClient.setZipcode(client.getZipcode());
        newClient.setPhonenumber(client.getPhonenumber());

        if (conseillerRepository.findById(client.getId_conseiller()).isEmpty()) {
            throw new RuntimeException("Conseiller avec l'ID correspondant non trouvé.");
        }

        newClient.setConseiller(conseillerRepository.findById(client.getId_conseiller()).get());

        return clientRepository.saveAndFlush(newClient);
    }
    @Override
    public void deleteClient(Integer id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
        } else throw new RuntimeException("Le client n'existe pas");
    }

    @Override
    public Client updateClient(Integer id, ClientDto client) {
        if (clientRepository.existsById(id)){
            Client existingClient = clientRepository.findById(id).get();
            existingClient.setLastname(client.getLastname());
            existingClient.setFirstname(client.getFirstname());
            existingClient.setCity(client.getCity());
            existingClient.setAddress(client.getAddress());
            existingClient.setPhonenumber(client.getPhonenumber());
            existingClient.setZipcode(client.getZipcode());
            if (conseillerRepository.existsById(client.getId_conseiller())){
                existingClient.setConseiller(conseillerRepository.findById(client.getId_conseiller()).get());
            } else throw new RuntimeException("Wesh, tu veux changer de conseiller, mais prends en un qui existe !");

            return clientRepository.save(existingClient);
        } else throw new RuntimeException("Wesh, tu veux modifier un client qui n'existe pas, t'es bizarre toi !");

    }
}
