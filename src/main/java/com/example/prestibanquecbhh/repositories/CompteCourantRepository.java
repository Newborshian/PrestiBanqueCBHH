package com.example.prestibanquecbhh.repositories;

import com.example.prestibanquecbhh.entities.CompteCourant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompteCourantRepository extends JpaRepository<CompteCourant, Integer> {

    List<CompteCourant> findAllBySoldeLessThan(Integer solde);
    CompteCourant findByNumerodecompte(Integer numeroDeCompte);

}
