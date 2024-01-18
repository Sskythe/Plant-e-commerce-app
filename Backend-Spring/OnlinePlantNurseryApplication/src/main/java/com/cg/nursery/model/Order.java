package com.cg.nursery.model;

import java.time.LocalDate;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "order_tbl")
public class Order {
	@Id
	@GeneratedValue(generator="order_seq",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="order_seq", sequenceName="order_id_seq",allocationSize=1)
	private Integer bookingOrderId;
	@Column
	@JsonFormat(pattern="dd-MM-yyyy")
	private LocalDate OrderDate;
	
	
	@Column(length=20)
	private String transactionMode;
	@Column
	private int quantity;
	@Column
	private double totalCost;
	
	
	@OneToMany(targetEntity=Planter.class,cascade=CascadeType.ALL)
	@JoinColumn(name="booking_id",referencedColumnName="bookingOrderId")
	private List<Planter> planters;
	
	


	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Order(Integer bookingOrderId, LocalDate orderDate, String transactionMode, int quantity, double totalCost,
			List<Planter> planters) {
		super();
		this.bookingOrderId = bookingOrderId;
		OrderDate = orderDate;
		this.transactionMode = transactionMode;
		this.quantity = quantity;
		this.totalCost = totalCost;
		this.planters = planters;
	}




	public Integer getBookingOrderId() {
		return bookingOrderId;
	}




	public void setBookingOrderId(Integer bookingOrderId) {
		this.bookingOrderId = bookingOrderId;
	}




	public LocalDate getOrderDate() {
		return OrderDate;
	}




	public void setOrderDate(LocalDate orderDate) {
		OrderDate = orderDate;
	}




	public String getTransactionMode() {
		return transactionMode;
	}




	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}




	public int getQuantity() {
		return quantity;
	}




	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}




	public double getTotalCost() {
		return totalCost;
	}




	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}




	public List<Planter> getPlanters() {
		return planters;
	}




	public void setPlanters(List<Planter> planters) {
		this.planters = planters;
	}




	@Override
	public String toString() {
		return "Order [bookingOrderId=" + bookingOrderId + ", OrderDate=" + OrderDate + ", transactionMode="
				+ transactionMode + ", quantity=" + quantity + ", totalCost=" + totalCost + ", planters=" + planters
				+ "]";
	}




	
	
	


	
	

	
	
	
	
	
	
	

	

	
	
	
	

}
