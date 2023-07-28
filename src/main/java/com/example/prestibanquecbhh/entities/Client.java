package com.example.prestibanquecbhh.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "client")
@Getter
@Setter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "zipcode")
    private Integer zipcode;
    @Column(name = "phonenumber")
    private String phonenumber;
    @ManyToOne
    @JoinColumn(name = "id_conseiller")
    private Conseiller conseiller;
}
