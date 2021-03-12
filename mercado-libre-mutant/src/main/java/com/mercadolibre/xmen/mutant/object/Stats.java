package com.mercadolibre.xmen.mutant.object;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stats implements Serializable {

	@SerializedName("count_mutant_dna")
	@Expose
	private long countMutantDna;
	@SerializedName("count_human_dna")
	@Expose
	private long countHumanDna;
	@SerializedName("ratio")
	@Expose
	private float ratio;
	private final static long serialVersionUID = 1943196147319134082L;

	public long getCountMutantDna() {
		return countMutantDna;
	}

	public void setCountMutantDna(long countMutantDna) {
		this.countMutantDna = countMutantDna;
	}

	public long getCountHumanDna() {
		return countHumanDna;
	}

	public void setCountHumanDna(long countHumanDna) {
		this.countHumanDna = countHumanDna;
	}

	public float getRatio() {
		return ratio;
	}

	public void setRatio(float ratio) {
		this.ratio = ratio;
	}

}
