package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Sobrevivente;

@Repository
public interface SobreviventeRepository extends JpaRepository<Sobrevivente, Long> {

	@Query("SELECT COUNT(*) FROM Sobrevivente")
	Integer obterQtdTotal();

	@Query("SELECT COUNT(*) FROM Sobrevivente where infectado=1")
	Integer obterQtdInfectado();
}
