package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.RelatorioInfeccao;
import com.example.service.RelatorioInfeccaoService;

@RestController 
@RequestMapping("/relatorio-infeccao") 
public class RelatorioInfeccaoController {

	@Autowired
	private RelatorioInfeccaoService service;

	@RequestMapping(value = "/relatar", method = RequestMethod.POST) 
	public Boolean salvar(@RequestBody RelatorioInfeccao relatorioInfeccao) { 

		return this.service.salvarRelatoInfeccao(relatorioInfeccao);

	}

}
