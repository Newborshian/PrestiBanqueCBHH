package com.example.prestibanquecbhh.repositories;

import com.example.prestibanquecbhh.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepositoty extends JpaRepository<Client, Integer> {
}
