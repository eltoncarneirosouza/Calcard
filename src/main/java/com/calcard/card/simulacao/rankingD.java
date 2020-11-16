package com.calcard.card.simulacao;

import com.calcard.card.model.Pessoa;

public class rankingD implements Calculo{

    @Override
    public double emprestimo(Pessoa pessoa) {
	double renda = pessoa.getRenda();
	return renda * 2.0;
    }

}
