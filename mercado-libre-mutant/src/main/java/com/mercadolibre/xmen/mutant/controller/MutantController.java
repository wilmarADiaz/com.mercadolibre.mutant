package com.mercadolibre.xmen.mutant.controller;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.xmen.mutant.object.Dna;
import com.mercadolibre.xmen.mutant.utils.ValidatorRequest;

@RestController
@Validated
public class MutantController {
	@PostMapping(value = "/mutant", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> validateMutante(@Valid @RequestBody Dna dna){
		
		System.out.println("Funciono:"+ValidatorRequest.isValid(dna.getDna()));
		return ResponseEntity.ok().body("");
	}
	
	@GetMapping(value = "/stats", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> stadistics(){
		return ResponseEntity.ok().body("");
	}
	
	
}
