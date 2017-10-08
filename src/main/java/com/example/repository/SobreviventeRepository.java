package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Sobrevivente;

@Repository
public interface SobreviventeRepository extends JpaRepository<Sobrevivente, Long> {

}
