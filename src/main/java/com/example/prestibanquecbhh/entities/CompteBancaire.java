package com.example.prestibanquecbhh.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "comptebancaire")
public class CompteBancaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "numerodecompte")
    private Integer numeroDeCompte;
    @Column(name = "typedecompte")
    private String typeDeCompte;
    @Column(name = "solde")
    private Double solde;
    @Column(name = "createdat")
    private String createdAt;
    @ManyToOne()
    @JoinColumn(name = "id_client")
    private Client client;

}
