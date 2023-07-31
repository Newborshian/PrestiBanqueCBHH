package com.example.prestibanquecbhh.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "conseiller")
@Getter
@Setter
public class Conseiller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "firstname")
    private String firstName;
}
