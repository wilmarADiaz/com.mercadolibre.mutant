package com.mercadolibre.xmen.mutant.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.xmen.mutant.object.Dna;
import com.mercadolibre.xmen.mutant.service.MutantService;
import com.mercadolibre.xmen.mutant.utils.RequestValidator;

@RestController
@Validated
public class MutantController {
	@Autowired
	private MutantService service;
	@PostMapping(value = "/mutant", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> validateMutante(@Valid @RequestBody Dna dna){		
		ResponseEntity<String> response = null;
		if(RequestValidator.isValid(dna.getDna())) {
			if(service.isMutant(dna.getDna())) {
				response = ResponseEntity.ok().body("");
			}else {
				response = ResponseEntity.status(HttpStatus.FORBIDDEN).body("");
			}
			
		}else {
			response = ResponseEntity.badRequest().body("");
		}
		
		return response;
	}
	
	@GetMapping(value = "/stats", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> stadistics(){
		return ResponseEntity.ok().body("");
	}
	
	
}
