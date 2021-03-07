package com.mercadolibre.xmen.mutant.service;

import java.util.List;

import com.mercadolibre.xmen.mutant.utils.MutantArrayValidation;

public class MutantThread implements Runnable{
	private int typeSearchMutant;
	private List<String> dna;
	private int secuences;
	public MutantThread(List<String> dna, int typeSearchMutant) {
		this.typeSearchMutant = typeSearchMutant;
		this.dna = dna;
	}
	@Override
	public void run() {
		secuences=MutantArrayValidation.validateArray(dna, this.typeSearchMutant);
		
	}
	public int getTypeSearchMutant() {
		return typeSearchMutant;
	}
	public void setTypeSearchMutant(int typeSearchMutant) {
		this.typeSearchMutant = typeSearchMutant;
	}
	public List<String> getDna() {
		return dna;
	}
	public void setDna(List<String> dna) {
		this.dna = dna;
	}
	public int getSecuences() {
		return secuences;
	}
	public void setSecuences(int secuences) {
		this.secuences = secuences;
	}

}
