package com.lucianoortizsilva.reports.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.RandomUtils;

public class GeraFuncionarioAleatorio {

	public static void main(String[] args) {

		String[] nomes = { "Luciano", "Mariana", "Vanessa", "Liziane", "Lucas", "Rafaela", "Amanda", "Adão" };
		String[] sobrenomes1 = { "Ortiz", "Silva", "Almeida", "Da Silva", "Oliveira", "Costas", "Gomes", "Sanches" };
		String[] sobrenomes2 = { "Carneiro", "Vasconselos", "Scott", "Escobar", "Mendes", "Alcantara", "Pinto", "Bolsonaro" };
		String[] sobrenomes3 = { "I", "II", "III", "IV", "V", "VI", "VII", "VIII" };

		final StringBuilder sql = new StringBuilder();

		for (int i = 1; i <= 200; i++) {
			String nome = nomes[RandomUtils.nextInt(0, 8)];
			String sobrenome1 = sobrenomes1[RandomUtils.nextInt(0, 8)];
			String sobrenome2 = sobrenomes2[RandomUtils.nextInt(0, 8)];
			String sobrenome3 = sobrenomes3[RandomUtils.nextInt(0, 8)];
			String nomeCompleto = nome + " " + sobrenome1 + " " + sobrenome2 + " " + sobrenome3;
			
			Date MIN_DATE_A = new Date(Long.MIN_VALUE);
			Date MAX_DATE_A = new Date(Long.MAX_VALUE);
			Date DATE_ALEATORIA_A = between(MIN_DATE_A, MAX_DATE_A);
			SimpleDateFormat X_A = new SimpleDateFormat("yy-MM-dd");
			String date_A = "19" + X_A.format(DATE_ALEATORIA_A);
			
			Date MIN_DATE_B = new Date(Long.MIN_VALUE);
			Date MAX_DATE_B = new Date(Long.MAX_VALUE);
			Date DATE_ALEATORIA_B = between(MIN_DATE_B, MAX_DATE_B);
			SimpleDateFormat X_B = new SimpleDateFormat("yy-MM-dd");
			String date_B = "19" + X_B.format(DATE_ALEATORIA_B);
			
			Integer endereco = RandomUtils.nextInt(1, 200);
			Integer nivel = RandomUtils.nextInt(1, 5);
			Integer cargo = RandomUtils.nextInt(1, 12);
			
			sql.append("(")
			.append(i).append(",")
			.append('\'').append(nomeCompleto).append('\'').append(",")
			.append('\'').append(date_A).append('\'').append(",")
			.append("_binary'`").append(",")
			.append('\'').append("'").append('\'').append(",")
			.append('\'').append(new BigDecimal(RandomUtils.nextDouble(100.00, 10000)).setScale(2, RoundingMode.DOWN)).append('\'').append(",")
			.append('\'').append(date_B).append('\'').append(",")
			.append("null").append(",")
			.append(endereco).append(",")
			.append(nivel).append(",")
			.append(cargo)
			.append("),\n");
		}
		
		System.out.println(sql.toString());

	}
	
	public static Date between(Date startInclusive, Date endExclusive) {
	    long startMillis = startInclusive.getTime();
	    long endMillis = endExclusive.getTime();
	    long randomMillisSinceEpoch = ThreadLocalRandom
	      .current()
	      .nextLong(startMillis, endMillis);

	    return new Date(randomMillisSinceEpoch);
	}

}
