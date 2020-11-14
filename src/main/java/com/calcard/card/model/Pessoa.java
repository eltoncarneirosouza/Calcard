package com.calcard.card.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;
    private int idade;
    private String cpf;
    private int dependentes;
    private double renda;

    public Pessoa() {

    }

    public Pessoa(String nome, int idade, String cpf, int dependentes, double renda) {
	this.nome = nome;
	this.idade = idade;
	this.cpf = cpf;
	this.dependentes = dependentes;
	this.renda = renda;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
	result = prime * result + dependentes;
	result = prime * result + idade;
	result = prime * result + ((nome == null) ? 0 : nome.hashCode());
	long temp;
	temp = Double.doubleToLongBits(renda);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Pessoa other = (Pessoa) obj;
	if (cpf == null) {
	    if (other.cpf != null)
		return false;
	} else if (!cpf.equals(other.cpf))
	    return false;
	if (dependentes != other.dependentes)
	    return false;
	if (idade != other.idade)
	    return false;
	if (nome == null) {
	    if (other.nome != null)
		return false;
	} else if (!nome.equals(other.nome))
	    return false;
	if (Double.doubleToLongBits(renda) != Double.doubleToLongBits(other.renda))
	    return false;
	return true;
    }

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
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

    public String getCpf() {
	return cpf;
    }

    public void setCpf(String cpf) {
	this.cpf = cpf;
    }

    public int getDependentes() {
	return dependentes;
    }

    public void setDependentes(int dependentes) {
	this.dependentes = dependentes;
    }

    public double getRenda() {
	return renda;
    }

    public void setRenda(double renda) {
	this.renda = renda;
    }

    @Override
    public String toString() {
	return "Pessoa [id=" + id + ", nome=" + nome + ", idade=" + idade + ", cpf=" + cpf + ", dependentes="
		+ dependentes + ", renda=" + renda + "]";
    }
}
