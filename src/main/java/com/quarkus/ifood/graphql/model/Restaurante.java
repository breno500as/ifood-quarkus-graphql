package com.quarkus.ifood.graphql.model;

public class Restaurante {

	private String nome;
	private String dono;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDono() {
		return dono;
	}

	public void setDono(String dono) {
		this.dono = dono;
	}

}
