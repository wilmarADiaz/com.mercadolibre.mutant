package com.mercadolibre.xmen.mutant.utils;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import com.google.gson.Gson;
import com.mercadolibre.xmen.mutant.object.Dna;

@SpringBootTest
class MutantArrayValidationTest {
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
	void numSecuencesHorizontalAboveTest() {
		setUp();
		assertEquals(0, MutantArrayValidation.numSecuencesHorizontalAbove(dna.getDna()));
	}
	
	@Test
	void numSecuencesHorizontalBelowTest() {
		setUp();
		assertEquals(1, MutantArrayValidation.numSecuencesHorizontalBelow(dna.getDna()));
	}
	
	@Test
	void numSecuencesVerticalLeftTest() {
		setUp();
		assertEquals(0, MutantArrayValidation.numSecuencesVerticalLeft(dna.getDna()));
	}
	
	@Test
	void numSecuencesVerticalRightTest() {
		setUp();
		assertEquals(1, MutantArrayValidation.numSecuencesVerticalRight(dna.getDna()));
	}
	
	@Test
	void numSecuencesDiagonalAboveRightLeftTest() {
		setUp();
		assertEquals(1, MutantArrayValidation.numSecuencesDiagonalAboveRightLeft(dna.getDna()));
	}
	
	@Test
	void numSecuencesDiagonalBelowRightLeftTest() {
		setUp();
		assertEquals(0, MutantArrayValidation.numSecuencesDiagonalBelowRightLeft(dna.getDna()));
	}
	
	@Test
	void numSecuencesDiagonalAboveLeftRightTest() {
		setUp();
		assertEquals(0, MutantArrayValidation.numSecuencesDiagonalAboveLeftRight(dna.getDna()));
	}
	
	@Test
	void numSecuencesDiagonalBelowLeftRightTest() {
		setUp();
		assertEquals(0, MutantArrayValidation.numSecuencesDiagonalBelowLeftRight(dna.getDna()));
	}

}
