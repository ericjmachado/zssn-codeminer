package com.example.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Inventario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	@OneToOne
	private Sobrevivente sobrevivente;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "inventario", cascade = CascadeType.ALL)
	private List<ItemInventario> itens;

	public List<ItemInventario> getItens() {
		return itens;
	}

	public void setItens(List<ItemInventario> itens) {
		this.itens = itens;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Sobrevivente getSobrevivente() {
		return sobrevivente;
	}

	public void setSobrevivente(Sobrevivente sobrevivente) {
		this.sobrevivente = sobrevivente;
	}

}
