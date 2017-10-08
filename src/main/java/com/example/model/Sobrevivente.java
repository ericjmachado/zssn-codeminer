package com.example.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Sobrevivente {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	private String nome;
	
	@Column(nullable=true)
	private int idade;

	@Column(nullable=true)
	private char sexo;

	@Column(nullable=true)
	private double latitude;

	@Column(nullable=true)
	private double longitude;

	@Column(nullable=true)
	private boolean infectado;

	@OneToOne(optional=true, cascade=CascadeType.PERSIST)
	private Inventario inventario;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Inventario getInventario() {
		return inventario;
	}

	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public boolean isInfectado() {
		return infectado;
	}

	public void setInfectado(boolean infectado) {
		this.infectado = infectado;
	}

}
