package com.mercadolibre.xmen.mutant.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.mercadolibre.xmen.mutant.object.Stats;
import com.mercadolibre.xmen.mutant.persistence.entity.RecruitingMutantEntity;
import com.mercadolibre.xmen.mutant.persistence.repository.RecruitingMutantRepository;

@Service
public class MutantService {
	
	@Resource
	private RecruitingMutantRepository repository;
	
	private Gson gson;
	
	public boolean isMutant(List<String> dna) {
		MutantThread thread1 = new MutantThread(dna, 1);
		MutantThread thread2 = new MutantThread(dna, 2);
		MutantThread thread3 = new MutantThread(dna, 3);
		MutantThread thread4 = new MutantThread(dna, 4);
		MutantThread thread5 = new MutantThread(dna, 5);
		MutantThread thread6 = new MutantThread(dna, 6);
		MutantThread thread7 = new MutantThread(dna, 7);
		MutantThread thread8 = new MutantThread(dna, 8);
		
		new Thread(thread1).start();
		new Thread(thread2).start();
		new Thread(thread3).start();
		new Thread(thread4).start();
		new Thread(thread5).start();
		new Thread(thread6).start();
		new Thread(thread7).start();
		new Thread(thread8).start();
		
		int secuence = 0;
		secuence = secuence + thread1.getSecuences();
		secuence = secuence + thread2.getSecuences();
		secuence = secuence + thread3.getSecuences();
		secuence = secuence + thread4.getSecuences();
		secuence = secuence + thread5.getSecuences();
		secuence = secuence + thread6.getSecuences();
		secuence = secuence + thread7.getSecuences();
		return secuence>1;
	}
	
	public boolean saveDna(List<String> dna, boolean isMutant) {
		RecruitingMutantEntity entity = new RecruitingMutantEntity();
		RecruitingMutantEntity entitySave = null;
		boolean saveOk = true;
		gson= new Gson();
		entity.setDna(gson.toJson(dna));
		entity.setMutant(isMutant);
	
		entitySave = repository.save(entity);
		if(entitySave == null ||  entitySave.getDna() == null) {
			saveOk=false;
		}
		return saveOk;
	}	
	
	public String stadistics() {
		long numHumans = repository.count();
		long numMutants = repository.countByMutant(true);
		gson= new Gson();
		Stats stats = new Stats();
		stats.setCountHumanDna(numHumans);
		stats.setCountMutantDna(numMutants);
		stats.setRatio((numMutants*100)/numHumans);
		
		return gson.toJson(stats);
	}
	
}
