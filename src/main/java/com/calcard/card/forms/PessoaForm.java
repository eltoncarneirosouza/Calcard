package com.calcard.card.forms;

import com.calcard.card.model.Pessoa;

public class PessoaForm {
    private String nome;
    private int idade;
    private String cpf;
    private int dependentes;
    private double renda;

    public void setNome(String nome) {
	this.nome = nome;
    }

    public void setIdade(int idade) {
	this.idade = idade;
    }

    public void setCpf(String cpf) {
	this.cpf = cpf;
    }

    public void setDependentes(int dependentes) {
	this.dependentes = dependentes;
    }

    public void setRenda(double renda) {
	this.renda = renda;
    }

    public Pessoa converter() {
	return new Pessoa(this.nome, this.idade, this.cpf, this.dependentes, this.renda);
    }

}
