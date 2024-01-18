package com.cg.nursery.service;



import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.nursery.exception.PlantException;

import com.cg.nursery.model.Plant;

public interface IPlantService {
	
	
	public ResponseEntity<Plant> addPlant(Plant plant) throws PlantException;
	
	public ResponseEntity<Plant> updatePlant(Plant plant) throws PlantException;
	
	public ResponseEntity<Plant> deletePlant(int plantId) throws PlantException;
	
	public ResponseEntity<Plant> viewPlant(int plantId) throws PlantException;
	
	public ResponseEntity<Plant> viewPlant(String commonName) throws PlantException;
	
	public ResponseEntity<List<Plant>> viewAllPlants() throws PlantException;
	
	public ResponseEntity<List<Plant>> viewAllPlants(String typeOfPlant) throws PlantException;

}
