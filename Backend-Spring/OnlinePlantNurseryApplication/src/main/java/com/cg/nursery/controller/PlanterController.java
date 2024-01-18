package com.cg.nursery.controller;



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

import com.cg.nursery.exception.PlanterException;
import com.cg.nursery.model.Planter;
import com.cg.nursery.service.PlanterService;

@RestController
@RequestMapping("/planter")
@CrossOrigin("*")
public class PlanterController {
	
	@Autowired
	PlanterService service;
	
	@PostMapping("/add")
	public ResponseEntity<?> addPlanter(@RequestBody Planter planter) throws PlanterException{
		
		return service.addPlanter(planter);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updatePlanter(@RequestBody Planter planter) throws PlanterException{
		
		return service.updatePlanter(planter);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deletePlanter(@PathVariable("id") int planterId) throws PlanterException{
		return service.deletePlanter(planterId);
	}
	
	@GetMapping("/viewById/{id}")
	public ResponseEntity<?> viewPlanter(@PathVariable("id") int planterId) throws PlanterException{
		
		return service.viewPlanter(planterId);
		
	}
	
	@GetMapping("/viewByName/{shape}")
	public ResponseEntity<?> viewPlanter(@PathVariable("shape") String planterShape) throws PlanterException{
		return service.viewPlanter(planterShape);
	}
	
	@GetMapping("/viewAll")
	public ResponseEntity<?> viewAllPlanters()throws PlanterException{
		return service.viewAllPlanters();
	}
	
	@GetMapping("/viewByCost/{min}/{max}")
	public ResponseEntity<?> viewAllPlanters(@PathVariable("min") double minCost,@PathVariable("max") double maxCost)throws PlanterException{
		return service.viewAllPlanters(minCost, maxCost);
	}
}
