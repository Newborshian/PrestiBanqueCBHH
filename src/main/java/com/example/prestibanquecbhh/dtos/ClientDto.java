package com.example.prestibanquecbhh.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientDto {
    private Integer id;
    private String lastname;
    private String firstname;
    private String address;
    private String city;
    private Integer zipcode;
    private String phonenumber;
    private Integer id_conseiller;
}
