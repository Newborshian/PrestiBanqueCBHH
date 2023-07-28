package com.example.prestibanquecbhh.repositories;

import com.example.prestibanquecbhh.entities.CompteBancaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteBancaireRepository extends JpaRepository<CompteBancaire, Integer> {
}
