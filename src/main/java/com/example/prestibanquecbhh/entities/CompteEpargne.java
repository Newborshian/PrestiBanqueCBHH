package com.example.prestibanquecbhh.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "compteepargne")
public class CompteEpargne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "numerodecompte")
    private Integer numerodecompte;
    @Column(name = "solde")
    private Double solde;
    @Column(name = "createdat")
    private String createdat;
    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;
    @Column(name = "tauxinteret")
    private Double tauxInteret;

}
