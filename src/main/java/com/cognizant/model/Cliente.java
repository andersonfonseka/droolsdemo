package com.cognizant.model;

public class Cliente {
	
	private String nome;
	
	private int idade;
	
	private String genero;
	
	private double salario;

	public Cliente() {
		super();
	}

	public Cliente(String nome, int idade, String genero, double salario) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.genero = genero;
		this.salario = salario;
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

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
		
}
