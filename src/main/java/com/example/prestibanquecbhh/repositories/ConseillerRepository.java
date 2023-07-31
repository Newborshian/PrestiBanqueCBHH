package com.example.prestibanquecbhh.repositories;

import com.example.prestibanquecbhh.entities.Client;
import com.example.prestibanquecbhh.entities.Conseiller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConseillerRepository extends JpaRepository<Conseiller, Integer> {


}
