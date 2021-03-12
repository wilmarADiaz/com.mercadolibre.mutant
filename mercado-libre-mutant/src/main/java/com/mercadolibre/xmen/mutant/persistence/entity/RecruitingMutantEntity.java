package com.mercadolibre.xmen.mutant.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RECRUITING_MUTANT", schema = "xmen_mutant_mercadolibre_db")
public class RecruitingMutantEntity  implements Serializable{
	private static final long serialVersionUID = -9202332324092707793L;
	
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "dna")
	private String dna;
	@Column(name = "mutant")
	private boolean mutant;
	
	public RecruitingMutantEntity() {}
	
	public RecruitingMutantEntity(int id, String dna, boolean mutant) {
		super();
		this.id = id;
		this.dna = dna;
		this.mutant = mutant;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDna(){
		return dna;
	}

	public void setDna(String dna){
		this.dna=dna;
	}

	public boolean isMutant(){
		return mutant;
	}

	public void setMutant(boolean mutant){
		this.mutant=mutant;
	}

}
