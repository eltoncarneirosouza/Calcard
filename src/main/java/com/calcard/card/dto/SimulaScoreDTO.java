package com.calcard.card.dto;

import com.calcard.card.model.Pessoa;
import com.calcard.card.simulacao.ExecutaCalculo;
import com.calcard.card.simulacao.rankingA;
import com.calcard.card.simulacao.rankingB;
import com.calcard.card.simulacao.rankingC;
import com.calcard.card.simulacao.rankingD;
import com.calcard.card.util.Metodos;

public class SimulaScoreDTO {
    private String nome;
    private int idade;
    private String cpf;
    private int dependentes;
    private String renda;
    private int score;
    private String resultado;

    public SimulaScoreDTO(Pessoa pessoa) {
	this.nome = pessoa.getNome();
	this.idade = pessoa.getIdade();
	this.cpf = pessoa.getCpf();
	this.dependentes = pessoa.getDependentes();
	this.renda = Metodos.formataCurrency(pessoa.getRenda());
	this.score = Metodos.escore();
	double emprestimo = 0;
	ExecutaCalculo calculo = new ExecutaCalculo();
	if(this.score >=0 && this.score <= 200) {
	    emprestimo = calculo.executa(pessoa, new rankingD());
	}else if (this.score > 200 && this.score <= 400) {
	    emprestimo = calculo.executa(pessoa, new rankingC());
	}
	else if (this.score > 400 && this.score <= 600) {
	    emprestimo = calculo.executa(pessoa, new rankingB());
	}
	else if (this.score > 600) {
	    emprestimo = calculo.executa(pessoa, new rankingA());
	}
	this.resultado = Metodos.formataCurrency(emprestimo);
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

    public String getResultado() {
	return resultado;
    }

}
