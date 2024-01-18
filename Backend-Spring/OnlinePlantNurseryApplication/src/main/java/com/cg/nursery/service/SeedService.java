package com.cg.nursery.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.nursery.dao.ISeedRepository;

import com.cg.nursery.exception.SeedException;
import com.cg.nursery.model.Plant;
import com.cg.nursery.model.Seed;

@Service
public class SeedService implements ISeedService{
	@Autowired
	ISeedRepository ir;
	

	//insert new seed to database
	public ResponseEntity<Seed> addSeed(Seed seed) throws SeedException{
		if(seed==null || seed.getCommonName()==null || seed.getBloomTime()==null
				||seed.getWatering()==null || seed.getDifficultyLevel()==null ||
				seed.getTemperature()==null || seed.getTypeOfSeeds()==null ||
				seed.getSeedsDescription()==null || seed.getSeedsStock()==null
				||seed.getSeedsCost()==null || seed.getSeedsPerPacket()==null) {
			throw new SeedException("Can't addSeed as all necessary details are not provided");
		}
		ir.save(seed);
		return new ResponseEntity<Seed>(seed, HttpStatus.OK);
	}
	
	
	//update existing seed in database
	public ResponseEntity<Seed> updateSeed(Seed seed) throws SeedException{
		if(!ir.existsById(seed.getSeedId()) || seed.getCommonName()==null || seed.getBloomTime()==null
				||seed.getWatering()==null || seed.getDifficultyLevel()==null ||
				seed.getTemperature()==null || seed.getTypeOfSeeds()==null ||
				seed.getSeedsDescription()==null || seed.getSeedsStock()==null
				||(Double)seed.getSeedsCost()==null || seed.getSeedsPerPacket()==null){
			throw new SeedException("Can't update the seed details");
		}
		
		ir.save(seed);
		return new ResponseEntity<Seed>(seed, HttpStatus.OK);
	}
	
	
	//delete seed from database
	public ResponseEntity<Seed> deleteSeed(int seedId) throws SeedException{
		if(ir.existsById(seedId)) {
			Seed p=ir.findById(seedId).get();
	        ir.deleteById(seedId);
	        
			return new ResponseEntity<Seed>(p, HttpStatus.ACCEPTED);
		}
		throw new SeedException("Cant delete as data dont exist");
		
	}
	
	
	//retrival of a seed by its ID
	public ResponseEntity<Seed> viewSeed(int seedId) throws SeedException{
		if(ir.existsById(seedId)) {
			Seed seed=ir.findById(seedId).get();
			return new ResponseEntity<Seed>(seed, HttpStatus.OK);
		}
		throw new SeedException("No Seeds with this seedId");
	}
	
	
	//retrival of a seed on the basis of it's common name
	public ResponseEntity<Seed> viewSeed(String commonName) throws SeedException{
		
		Seed seed=ir.viewSeed(commonName);
		if(seed!=null)
			return new ResponseEntity<Seed>(seed, HttpStatus.OK);
		throw new SeedException("No Seeds with this commonName");
	}
	
	
	//List of all seeds
	public ResponseEntity<List<Seed>> viewAllSeed() throws SeedException{
		
		List<Seed> seedList=ir.findAll();
		if(seedList.size()==0)
			throw new SeedException("No Seeds avaiable");
		return new ResponseEntity<List<Seed>>(seedList, HttpStatus.OK);
		
	}
	
	//LIST of seeds according to a particular seed type
	public ResponseEntity<List<Seed>> viewAllSeed(String typeOfSeeds) throws SeedException{
		//this code will be changed in future
		List<Seed> seedList=ir.viewAllSeed(typeOfSeeds);
		if(seedList.size()!=0)
			return new ResponseEntity<List<Seed>>(seedList, HttpStatus.OK);
		throw new SeedException("No Seeds of this type");
		
	}

}
