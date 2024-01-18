package com.cg.nursery.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.nursery.exception.SeedException;
import com.cg.nursery.model.Seed;
import com.cg.nursery.service.SeedService;

@RestController
@RequestMapping("/seed")
@CrossOrigin("*")
public class SeedController {
	@Autowired
	SeedService service;
	
	@PostMapping("/addseed")
	public ResponseEntity<Seed> addSeed(@RequestBody Seed Seed) throws SeedException{
		
		return service.addSeed(Seed);
	}
	
	@PutMapping("/updateSeed")
	public ResponseEntity<Seed> updateSeed(@RequestBody Seed Seed) throws SeedException{
		
		return service.updateSeed(Seed);
	}
	
	@DeleteMapping("/deleteSeed/{id}")
	public ResponseEntity<Seed> deleteSeed(@PathVariable("id") int seedId) throws SeedException{
		return service.deleteSeed(seedId);
	}
	
	@GetMapping("/viewSeedById/{seedId}")
	public ResponseEntity<?> viewSeed(@PathVariable("seedId") int id) throws SeedException{
		return service.viewSeed(id);
		

	}
	@GetMapping("/viewSeedByCommonName/{name}")
	public ResponseEntity<Seed> viewSeedByCommonName(@PathVariable("name") String cName) throws SeedException{
		return service.viewSeed(cName);
	}
	
	@GetMapping("/viewAllSeed")
	public ResponseEntity<List<Seed>> viewAllSeed() throws SeedException{
		return service.viewAllSeed();
	}
	@GetMapping("/viewSeedsByType/{type}")
	public ResponseEntity<List<Seed>> viewSeedsByType(@PathVariable("type") String sType) throws SeedException{
	
		return service.viewAllSeed(sType);
	}
}
