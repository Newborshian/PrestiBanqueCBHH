package com.example.prestibanquecbhh.repositories;

import com.example.prestibanquecbhh.entities.Conseiller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConseillerRepository extends JpaRepository<Conseiller, Integer> {
}
