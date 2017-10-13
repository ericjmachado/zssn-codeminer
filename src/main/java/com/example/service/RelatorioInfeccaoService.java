package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.RelatorioInfeccao;
import com.example.model.Sobrevivente;
import com.example.repository.RelatorioInfeccaoRepository;
import com.example.repository.SobreviventeRepository;

@Service
public class RelatorioInfeccaoService {
	
	@Autowired 
	private RelatorioInfeccaoRepository repository;
	
	@Autowired
	private SobreviventeRepository sobreviventeRepository;
	
	/**
	 * Método para salvar um relátorio de infecção, e se houver mais de três relatos
	 * no Id do suposto infectado, o mesmo e declarado oficialmente infectado.
	 * @param relatorioInfeccao
	 * @return TRUE se o relator não for infectado, ou FALSE caso seja.
	 */
	public Boolean salvarRelatoInfeccao(RelatorioInfeccao relatorioInfeccao) {
		
		Sobrevivente relator = this.sobreviventeRepository.findOne(relatorioInfeccao.getSobreviventeRelator().getId());
		
		if(relator.isInfectado()) {
			
			return false;
			
		} else { 
		 
			this.repository.saveAndFlush(relatorioInfeccao);
			
			List<RelatorioInfeccao> lista = this.repository.findBySobreviventeInfectadoId(relatorioInfeccao.getSobreviventeInfectado().getId());
			
			
			if(lista.size() >= 3) {
				
				Sobrevivente infectado = this.sobreviventeRepository.findOne(relatorioInfeccao.getSobreviventeInfectado().getId());
				
				infectado.setInfectado(true);
				
				this.sobreviventeRepository.saveAndFlush(infectado);
				
			}
			
			return true;
		}
	}
}
