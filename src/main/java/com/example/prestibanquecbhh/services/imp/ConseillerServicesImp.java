package com.example.prestibanquecbhh.services.imp;

import com.example.prestibanquecbhh.dtos.ConseillerDto;
import com.example.prestibanquecbhh.entities.Client;
import com.example.prestibanquecbhh.entities.Conseiller;
import com.example.prestibanquecbhh.repositories.ClientRepository;
import com.example.prestibanquecbhh.repositories.ConseillerRepository;
import com.example.prestibanquecbhh.services.ConseillerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConseillerServicesImp implements ConseillerServices {

    @Autowired
    ConseillerRepository conseillerRepository;
    @Autowired
    ClientRepository clientRepository;

    @Override
    public ConseillerDto toDto(Conseiller conseiller) {
        ConseillerDto conseillerDto = new ConseillerDto();
        conseillerDto.setFirstName(conseiller.getFirstName());
        conseillerDto.setLastname(conseiller.getLastname());
        conseillerDto.setClientList(clientRepository.findByConseiller(conseiller));
        return conseillerDto;
    }

    @Override
    public List<ConseillerDto> getAllConseiller() {
        List<ConseillerDto> conseillerDtoList = new ArrayList<>();
        List<Conseiller> conseillerList = conseillerRepository.findAll();
        for (Conseiller conseiller : conseillerList){
            conseillerDtoList.add(toDto(conseiller));
        }
        return conseillerDtoList;
    }

    @Override
    public Conseiller saveConseiller(ConseillerDto conseillerDto) {
        Conseiller conseiller = new Conseiller();
        conseiller.setFirstName(conseillerDto.getFirstName());
        conseiller.setLastname(conseillerDto.getLastname());

        return conseillerRepository.saveAndFlush(conseiller);
    }

    @Override
    public void deleteConseiller(Integer id) {
        Conseiller conseiller = conseillerRepository.findById(id).get();
        List<Client> listeClientConseiller = clientRepository.findByConseiller(conseiller);
        Conseiller conseillerParDefault = conseillerRepository.findById(1).get();
        for (Client c : listeClientConseiller){
            c.setConseiller(conseillerParDefault);
            clientRepository.save(c);
        }
        conseillerRepository.deleteById(id);

    }

    @Override
    public Conseiller updateConseiller(Integer id, ConseillerDto conseillerDto) {
        Conseiller existingConseiller = conseillerRepository.findById(id).get();
        existingConseiller.setFirstName(conseillerDto.getFirstName());
        existingConseiller.setLastname(conseillerDto.getLastname());
        return conseillerRepository.save(existingConseiller);
    }
}
