package com.example.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ItemInventario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	@Enumerated(EnumType.STRING)
	private TipoItem tipo;

	private int qtdItem;
	
	@ManyToOne
	private Inventario inventario;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public TipoItem getTipo() {
		return tipo;
	}

	public void setTipo(TipoItem tipo) {
		this.tipo = tipo;
	}

	public int getQtdItem() {
		return qtdItem;
	}

	public void setQtdItem(int qtdItem) {
		this.qtdItem = qtdItem;
	}

	public Inventario getInventario() {
		return inventario;
	}

	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}
	
	
}
