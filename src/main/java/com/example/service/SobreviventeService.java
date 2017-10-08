package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Sobrevivente;
import com.example.repository.SobreviventeRepository;


@Service
public class SobreviventeService {

	@Autowired
	private SobreviventeRepository repository;

	public Boolean salvar(Sobrevivente sobrevivente) {
		
		sobrevivente.getInventario().setSobrevivente(sobrevivente);
		
		sobrevivente.getInventario().getItens().forEach(itemInventario -> {
			
			itemInventario.setInventario(sobrevivente.getInventario());
			
		});

		this.repository.saveAndFlush(sobrevivente);

		return Boolean.TRUE;

	}

}
