package com.calcard.card.dto;

import com.calcard.card.model.Pessoa;
import com.calcard.card.util.Metodos;

public class SimulaScoreDTO {
    private String nome;
    private int idade;
    private String cpf;
    private int dependentes;
    private String renda;
    private int score;
    private double resultado;

    public SimulaScoreDTO(Pessoa pessoa) {
	this.nome = pessoa.getNome();
	this.idade = pessoa.getIdade();
	this.cpf = pessoa.getCpf();
	this.dependentes = pessoa.getDependentes();
	this.renda = Metodos.formataCurrency(pessoa.getRenda());
	this.score = Metodos.escore();
    }

    public String getNome() {
	return nome;
    }

    public int getIdade() {
	return idade;
    }

    public String getCpf() {
	return cpf;
    }

    public int getDependentes() {
	return dependentes;
    }

    public String getRenda() {
	return renda;
    }

    public int getScore() {
	return score;
    }

    public double getResultado() {
	return resultado;
    }

}
