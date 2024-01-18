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

import com.cg.nursery.exception.PlantException;

import com.cg.nursery.model.Plant;

import com.cg.nursery.service.PlantService;

@RestController
@RequestMapping("/plant")
@CrossOrigin("*")
public class PlantController {
	@Autowired
	PlantService service;
	
	

	
	@PostMapping("/add")
	public ResponseEntity<Plant> addPlant(@RequestBody Plant plant) throws PlantException{
		
		return service.addPlant(plant);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Plant> updatePlant(@RequestBody Plant plant) throws PlantException{
		
		return service.updatePlant(plant);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Plant> deletePlant(@PathVariable("id") int plantId) throws PlantException{
		return service.deletePlant(plantId);
	}
	
	@GetMapping("/viewById/{id}")
	public ResponseEntity<Plant> viewPlant(@PathVariable("id") int plantId) throws PlantException{
		
		return service.viewPlant(plantId);
		
	}
	
	@GetMapping("/viewByName/{comName}")
	public ResponseEntity<Plant> viewPlant(@PathVariable("comName") String commonName) throws PlantException{
		return service.viewPlant(commonName);
	}
	
	@GetMapping("/viewAll")
	public ResponseEntity<List<Plant>> viewAllPlants() throws PlantException{
		return service.viewAllPlants();
	}
	
	@GetMapping("/viewAll/{typeOfPlant}")
	public ResponseEntity<List<Plant>> viewAllPlants(@PathVariable("typeOfPlant") String typeOfPlant) throws PlantException{
		return service.viewAllPlants(typeOfPlant);
	}

}
