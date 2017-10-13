package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class RelatorioInfeccao {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	@ManyToOne
	private Sobrevivente sobreviventeRelator;

	@ManyToOne
	private Sobrevivente sobreviventeInfectado;
	
	public Sobrevivente getSobreviventeRelator() { 
		return sobreviventeRelator;
	}

	public void setSobreviventeRelator(Sobrevivente sobreviventeRelator) {
		this.sobreviventeRelator = sobreviventeRelator;
	}

	public Sobrevivente getSobreviventeInfectado() {
		return sobreviventeInfectado;
	}

	public void setSobreviventeInfectado(Sobrevivente sobreviventeInfectado) {
		this.sobreviventeInfectado = sobreviventeInfectado;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
