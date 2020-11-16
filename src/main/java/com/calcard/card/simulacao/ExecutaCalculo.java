package com.calcard.card.simulacao;

import com.calcard.card.model.Pessoa;

public class ExecutaCalculo {
    public double executa(Pessoa pessoa, Calculo calculo) {
	return calculo.emprestimo(pessoa);
    }
}
