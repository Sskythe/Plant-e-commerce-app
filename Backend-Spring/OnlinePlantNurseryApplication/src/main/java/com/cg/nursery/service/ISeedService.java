package com.cg.nursery.service;

import java.util.List;

import org.springframework.http.ResponseEntity;


import com.cg.nursery.exception.SeedException;
import com.cg.nursery.model.Seed;

public interface ISeedService {
	
	public ResponseEntity<Seed> addSeed(Seed seed) throws SeedException;
	
	public ResponseEntity<Seed> updateSeed(Seed seed) throws SeedException;
	
	public ResponseEntity<Seed> deleteSeed(int seedId) throws SeedException;
	
	public ResponseEntity<Seed> viewSeed(int seedId) throws SeedException;
	
	public ResponseEntity<Seed> viewSeed(String commonName) throws SeedException;
	
	public ResponseEntity<List<Seed>> viewAllSeed() throws SeedException;
	
	public ResponseEntity<List<Seed>> viewAllSeed(String typeOfSeeds) throws SeedException;
	
	

}
