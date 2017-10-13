package com.example.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Relatorio;
import com.example.model.Sobrevivente;
import com.example.service.SobreviventeService;

@RestController
@RequestMapping("/sobrevivente") 
public class SobreviventeController {

	@Autowired
	private SobreviventeService service;
 
	@RequestMapping(value = "/salvar", method = RequestMethod.POST) 
	public Boolean salvar(@RequestBody Sobrevivente sobrevivente) {

		return this.service.salvar(sobrevivente);
		
	}

	
	@RequestMapping(value = "/alterar-localizacao", method = RequestMethod.POST) 
	public Boolean alterarLocalizacao(@RequestBody Sobrevivente sobrevivente) { 

		return this.service.alterarLocalizacao(sobrevivente);
		
	}
	
	@RequestMapping(value = "/obter-todos", method = RequestMethod.GET) 
	
	public List<Sobrevivente> obterTodos() { 

		return this.service.obterTodos();
		
	}
	
	@RequestMapping(value = "/relatorios", method = RequestMethod.GET) 
	public Relatorio obterRelatorio() { 

		return this.service.obterRelatorio();
		
	}
}
