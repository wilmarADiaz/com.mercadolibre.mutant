package com.mercadolibre.xmen.mutant.object;

import java.io.Serializable;
import java.util.List;


public class Dna implements Serializable {
	
	
	private List<String> dna = null;
	
	
	private final static long serialVersionUID = 6049713348533920097L;

	public List<String> getDna() {
		return dna;
	}

	public void setDna(List<String> dna) {
		this.dna = dna;
	}


}