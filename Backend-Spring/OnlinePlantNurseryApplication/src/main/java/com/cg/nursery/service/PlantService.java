package com.cg.nursery.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.nursery.dao.IPlantRepository;


import com.cg.nursery.exception.PlantException;

import com.cg.nursery.model.Plant;


@Service
public class PlantService implements IPlantService{
	
	@Autowired
	IPlantRepository dao;
	

	public ResponseEntity<Plant> addPlant(Plant plant) throws PlantException {
		if(plant==null || plant.getPlantHeight()==null ||plant.getPlantSpread()==null||
		plant.getCommonName()==null || plant.getBloomTime()==null ||plant.getMedicinalOrCulinaryUse()==null
		|| plant.getDifficultyLevel()==null|| plant.getTemperature()==null ||
		plant.getTypeOfPlant()==null || plant.getPlantDescription()==null
		|| plant.getPlantsStock()==null || (Double)plant.getPlantCost()==null)
					throw new PlantException("Can't addPlant as all necessary details are not provided");
		dao.save(plant);
		return new ResponseEntity<Plant>(plant, HttpStatus.OK);
	}
	
	
	
	
	public ResponseEntity<Plant> updatePlant(Plant plant) throws PlantException{
		if(!dao.existsById(plant.getPlantId()) || plant==null || plant.getPlantHeight()==null ||plant.getPlantSpread()==null||
				plant.getCommonName()==null || plant.getBloomTime()==null ||plant.getMedicinalOrCulinaryUse()==null
				|| plant.getDifficultyLevel()==null|| plant.getTemperature()==null ||
				plant.getTypeOfPlant()==null || plant.getPlantDescription()==null
				|| plant.getPlantsStock()==null || (Double)plant.getPlantCost()==null)
			throw new PlantException("Can't update the plant details");
            
        
        dao.save(plant);
        return new ResponseEntity<Plant>(plant, HttpStatus.OK); 
                
        
		
	}
	
	
	
	
	public ResponseEntity<Plant> deletePlant(int plantId) throws PlantException{
		if(dao.existsById(plantId))
        {
            
        
        Plant p=dao.findById(plantId).get();
        dao.deleteById(plantId);
        return new ResponseEntity<Plant>(p, HttpStatus.ACCEPTED);  
                
        }
		throw new PlantException("Can't delete as no plant with this plantId exist");
		
	}
	
	
	public ResponseEntity<Plant> viewPlant(int plantId) throws PlantException {
		if(dao.existsById(plantId)) {
			Plant p=dao.findById(plantId).get();
			return new ResponseEntity<Plant>(p, HttpStatus.OK);
		}
		throw new PlantException("No plant with this plantId");   
	}
	
	
	public ResponseEntity<Plant> viewPlant(String commonName) throws PlantException{
		List<Plant> data=new ArrayList<Plant>();
				data=dao.findAll();
		if(data.size()!=0) {
		for(Plant p:data) {
			if(p.getCommonName().equals(commonName)) {
				return new ResponseEntity<Plant>(p, HttpStatus.OK);
				
			}
		}
		}
		throw new PlantException("No plant Avaiable with this commonName");
		
	}
	
	public ResponseEntity<List<Plant>> viewAllPlants() throws PlantException{
		List<Plant> plants=dao.findAll();
		if(plants.size()==0)
			throw new PlantException("No plants Avaiable");
		
		return new ResponseEntity<List<Plant>>(plants, HttpStatus.OK);
			
	}
	
	public ResponseEntity<List<Plant>> viewAllPlants(String typeOfPlant) throws PlantException{
		List<Plant> all=dao.findAll();
		List<Plant> needed=new ArrayList<Plant>();
		if(all.size()!=0) {
		for(Plant p:all) {
			if(p.getTypeOfPlant().equals(typeOfPlant)) {
				needed.add(p);
			}
		}
		}
		
		if(needed.size()==0)
			throw new PlantException("No plants Avaiable og this type");
		
		return new ResponseEntity<List<Plant>>(needed, HttpStatus.OK);
			
	
	}

}
