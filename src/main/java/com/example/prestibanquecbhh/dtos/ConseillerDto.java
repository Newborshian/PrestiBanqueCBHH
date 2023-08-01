package com.example.prestibanquecbhh.dtos;

import com.example.prestibanquecbhh.entities.Client;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ConseillerDto {
    private Integer id;
    private String lastname;
    private String firstName;
    private List<Client> clientList;
}
