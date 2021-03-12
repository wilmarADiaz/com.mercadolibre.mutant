package com.mercadolibre.xmen.mutant.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import com.google.gson.Gson;
import com.mercadolibre.xmen.mutant.object.Dna;

@SpringBootTest
class RequestValidatorTest {
	private Dna dna;
	private Gson gson;
	
	@BeforeTestMethod
	void setUp() {
		gson = new Gson();
		String json = "{"
				+ "\"dna\":[\"ATGCGA\", \"CAGTGC\", \"TTATGT\", \"AGAAGG\", \"CCCCTA\", \"TCACTG\"]"
				+ "}";
		dna = gson.fromJson(json, Dna.class);
		
	}
	
	@Test
	void isValidTest() {
		setUp();		
		assertEquals(true,RequestValidator.isValid(dna.getDna()));
	}

}
