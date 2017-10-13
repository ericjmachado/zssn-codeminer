package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.RelatorioInfeccao;

@Repository
public interface RelatorioInfeccaoRepository extends JpaRepository<RelatorioInfeccao, Long>{  // E uma interface pois o Spring, implementa todos componentes para o repositório
	
	List<RelatorioInfeccao> findBySobreviventeInfectadoId(Long id);

}
