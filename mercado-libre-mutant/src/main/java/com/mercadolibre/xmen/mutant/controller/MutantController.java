package com.mercadolibre.xmen.mutant.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.xmen.mutant.object.Dna;
import com.mercadolibre.xmen.mutant.service.MutantService;
import com.mercadolibre.xmen.mutant.utils.RequestValidator;

@RestController
public class MutantController {
	@Autowired
	private MutantService service;
	
	private static final Logger log = LogManager.getLogger(MutantController.class);
	
	/**
	 * This is controller
	 * @param dna
	 * @return
	 */
	@PostMapping(value = "/mutant", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> validateMutante(@RequestBody Dna dna) {		
		ResponseEntity<String> response = null;
		if(RequestValidator.isValid(dna.getDna())) {
			if(service.isMutant(dna.getDna())) {
				try {
					if(!service.saveDna(dna.getDna(), true)) {
						log.error("Error when storing data");
					}
				}catch (Exception e) {
					log.error(e.getMessage()+":"+e);
				}
				response = ResponseEntity.ok().body("");
			}else {				
				try {
					if(!service.saveDna(dna.getDna(), false)) {
						log.error("Error when storing data");
					}
				}catch (Exception e) {
						log.error(e.getMessage()+":"+e);
				}
				response = ResponseEntity.status(HttpStatus.FORBIDDEN).body("");
			}
			
		}else {
			response = ResponseEntity.badRequest().body("");
		}
		
		return response;
	}
	
	@GetMapping(value = "/stats", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> stadistics(){
		service.stadistics();
		return ResponseEntity.ok().body(service.stadistics());
	}
	
	
}
