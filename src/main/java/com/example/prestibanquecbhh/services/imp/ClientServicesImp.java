package com.example.prestibanquecbhh.services.imp;

import com.example.prestibanquecbhh.dtos.ClientDto;
import com.example.prestibanquecbhh.entities.Client;
import com.example.prestibanquecbhh.repositories.ClientRepository;
import com.example.prestibanquecbhh.repositories.ConseillerRepository;
import com.example.prestibanquecbhh.services.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServicesImp implements ClientServices {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ConseillerRepository conseillerRepository;

    @Override
    public List<Client> getAllClient() {
        return clientRepository.findAll();
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
        newClient.setConseiller(conseillerRepository.findById(client.getId_conseiller()).get());
        return clientRepository.saveAndFlush(newClient);
    }

    @Override
    public void deleteClient(Integer id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Client updateClient(Integer id, ClientDto client) {
        Client existingClient = clientRepository.findById(id).get();
        existingClient.setLastname(client.getLastname());
        existingClient.setFirstname(client.getFirstname());
        existingClient.setCity(client.getCity());
        existingClient.setAddress(client.getAddress());
        existingClient.setPhonenumber(client.getPhonenumber());
        existingClient.setZipcode(client.getZipcode());
        existingClient.setConseiller(conseillerRepository.findById(client.getId_conseiller()).get());
        return clientRepository.save(existingClient);
    }
}
