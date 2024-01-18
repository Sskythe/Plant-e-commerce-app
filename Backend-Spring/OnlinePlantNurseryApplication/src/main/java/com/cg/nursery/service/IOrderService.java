package com.cg.nursery.service;

import java.util.List;
import org.springframework.http.ResponseEntity;
import com.cg.nursery.exception.OrderException;
import com.cg.nursery.model.Order;

public interface IOrderService {
	
	public ResponseEntity<Order> addOrder(Order ord) throws OrderException;
	
	public ResponseEntity<Order> updateOrder(Order ord) throws OrderException;
	
	public ResponseEntity<Order> deleteOrder(int orderId) throws OrderException;
	
	public ResponseEntity<Order> viewOrder(int orderId) throws OrderException;
	
	public ResponseEntity<List<Order>> viewAllOrders() throws OrderException;

}
