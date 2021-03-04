package com.mercadolibre.xmen.mutant.utils;

import java.util.List;

public class ValidatorRequest {
	public static boolean isValid (List<String> dna) {
		boolean isValidChain = true;
		int i = 0;
		while(dna != null && !dna.isEmpty() && isValidChain == true && dna.size() > i) {
			String stringTem = dna.get(i);
			if(!stringTem.matches("^[ATGC]*$")) {
				isValidChain = false;
			}
			i++;
		}
		return isValidChain;
	}
}
