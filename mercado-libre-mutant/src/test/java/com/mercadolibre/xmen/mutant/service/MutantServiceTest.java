package com.mercadolibre.xmen.mutant.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import com.google.gson.Gson;
import com.mercadolibre.xmen.mutant.object.Dna;
import com.mercadolibre.xmen.mutant.object.Stats;
import com.mercadolibre.xmen.mutant.persistence.entity.RecruitingMutantEntity;
import com.mercadolibre.xmen.mutant.persistence.repository.RecruitingMutantRepository;

@ExtendWith(MockitoExtension.class)
class MutantServiceTest {
	@InjectMocks
	MutantService service;
		
	private Dna dna;
	private Gson gson ;
	private Stats stats;
	
	@Mock
	RecruitingMutantRepository repository;
	
	@BeforeTestMethod
	void setUp() {
		gson = new Gson();
		String json = "{"
				+ "\"dna\":[\"ATGCGA\", \"CAGTGC\", \"TTATGT\", \"AGAAGG\", \"CCCCTA\", \"TCACTG\"]"
				+ "}";
		dna = gson.fromJson(json, Dna.class);
		
		stats = new Stats();
		stats.setCountHumanDna(100);
		stats.setCountMutantDna(30);
		stats.setRatio((float) 30.0);
	}
	
	@Test
	void isMutantTest() {
		setUp();
		assertEquals(true,service.isMutant(dna.getDna()));
	}
	
	@Test
	public void validateMutanteTest() {
		setUp();
		Mockito.when(repository.save(Mockito.any())).thenReturn(new RecruitingMutantEntity(1,gson.toJson(dna.getDna()),true));
		assertEquals(true, service.saveDna(dna.getDna(), false));
		
	}
	
	@Test
	public void stadisticsTest() {
		setUp();
		Mockito.when(repository.count()).thenReturn((long) 100);
		Mockito.when(repository.countByMutant(true)).thenReturn((long) 30);
		assertEquals(gson.toJson(stats), service.stadistics());
	}

}
