package com.mercadolibre.xmen.mutant.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MutantService {
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
		secuence = secuence + thread8.getSecuences();
		return secuence>1;
	}
	
}
