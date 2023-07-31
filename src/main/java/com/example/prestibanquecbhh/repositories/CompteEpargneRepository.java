package com.example.prestibanquecbhh.repositories;

import com.example.prestibanquecbhh.entities.CompteCourant;
import com.example.prestibanquecbhh.entities.CompteEpargne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteEpargneRepository extends JpaRepository<CompteEpargne, Integer> {


}
