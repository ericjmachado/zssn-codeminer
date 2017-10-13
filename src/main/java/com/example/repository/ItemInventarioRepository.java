package com.example.repository;

import java.util.List;

import org.springframework.context.annotation.Conditional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.Inventario;
import com.example.model.ItemInventario;
import com.example.model.RelatorioInfeccao;

public interface ItemInventarioRepository extends JpaRepository<ItemInventario, Long> {
	
	List<ItemInventario> findByInventario(Inventario inventario);
	
	@Query("SELECT SUM(qtdItem) FROM ItemInventario where tipo='AGUA'")
	Integer obterQuantidadeAgua();
	
	@Query("SELECT SUM(qtdItem) FROM ItemInventario where tipo='COMIDA'")
	Integer obterQuantidadeComida();
	
	@Query("SELECT SUM(qtdItem) FROM ItemInventario where tipo='MEDICACAO'")
	Integer obterQuantidadeMedicacao();
	
	@Query("SELECT SUM(qtdItem) FROM ItemInventario where tipo='MUNICAO'")
	Integer obterQuantidadeMunicao();

	
}
