package com.calcard.card.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class PessoaTest {

    @Test
    void validandoRenda() {
	Pessoa pessoa = new Pessoa("Elton", 36, "123.123.123-12", 3, 5500.0);
	assertEquals(5500.00, pessoa.getRenda());
	System.out.println(pessoa);
	
    }

}
