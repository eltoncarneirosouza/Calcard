package com.calcard.card.util;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;

public class Metodos {
    public static int escore() {
	Random gerador = new Random();
	int score = gerador.nextInt(1000);
	return score;
    }

    public static String formataCurrency(double valor) {
	Locale ptBr = new Locale("pt", "BR");
	String valorString = NumberFormat.getCurrencyInstance(ptBr).format(valor);
	return valorString;
    }
}
