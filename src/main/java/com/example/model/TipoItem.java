package com.example.model;

public enum TipoItem {

	AGUA(4), COMIDA(3), MEDICACAO(2), MUNICAO(1);
	
	private int ponto;

	TipoItem(int ponto) {
		this.ponto = ponto;
	}

	public int getPonto() {
		return ponto;
	}
}