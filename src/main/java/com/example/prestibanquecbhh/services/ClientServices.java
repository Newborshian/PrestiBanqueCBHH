package com.example.prestibanquecbhh.services;

import com.example.prestibanquecbhh.dtos.ClientDto;
import com.example.prestibanquecbhh.entities.Client;

import java.util.List;
import java.util.Optional;

public interface ClientServices {
    List<Client> getAllClient();
    Client saveClient(ClientDto client);
    void deleteClient(Integer id);
    Client updateClient(Integer id, ClientDto client);
}
