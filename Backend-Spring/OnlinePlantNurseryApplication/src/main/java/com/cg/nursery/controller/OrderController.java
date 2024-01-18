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

import com.cg.nursery.exception.OrderException;
import com.cg.nursery.model.Order;
import com.cg.nursery.service.OrderService;



	@RestController
	@RequestMapping("/order")
	@CrossOrigin("*")
	public class OrderController {
		
		@Autowired
		OrderService service;
		
		@PostMapping("/add")
		public ResponseEntity<?> addOrder(@RequestBody Order order) throws OrderException{
			
			return service.addOrder(order);
		}
		
		@PutMapping("/update")
		public ResponseEntity<?> updatePlanter(@RequestBody Order order) throws OrderException{
			
			return service.updateOrder(order);
		}
		
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<?> deleteOrder(@PathVariable("id") int bookingId ) throws OrderException{
			return service.deleteOrder(bookingId);
		}
		
		@GetMapping("/viewById/{id}")
		public ResponseEntity<?> viewOrder(@PathVariable("id") int bookingId) throws OrderException{
			
			return service.viewOrder(bookingId);
			
		}
		
		
		@GetMapping("/viewAll")
		public ResponseEntity<?> viewAllOrders()throws OrderException{
			return service.viewAllOrders();
		}
		
	}
