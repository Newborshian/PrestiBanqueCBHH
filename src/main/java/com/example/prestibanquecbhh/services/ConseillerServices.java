package com.example.prestibanquecbhh.services;

import com.example.prestibanquecbhh.dtos.ConseillerDto;
import com.example.prestibanquecbhh.entities.Conseiller;

import java.util.List;

public interface ConseillerServices {

    ConseillerDto toDto(Conseiller conseiller);
    List<ConseillerDto> getAllConseiller();
    Conseiller saveConseiller(ConseillerDto conseillerDto);
    void deleteConseiller(Integer id);
    Conseiller updateConseiller(Integer id, ConseillerDto conseillerDto);

}
