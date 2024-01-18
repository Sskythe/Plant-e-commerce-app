package com.cg.nursery.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name="address_tbl")
public class Address {
	
	@Id
	@GeneratedValue(generator="address_seq",strategy=GenerationType.SEQUENCE)
	@ SequenceGenerator(name="address_sql", sequenceName="address_id_seq",allocationSize=1)
	private int addressId;
	@Column(length=30)
	private String houseNo;
	@Column(length=20)
	private String colony;
	@Column(length=20)
	private String city ;
	@Column(length=20)
	private String state;
	@Column
	private int pincode;
	
	
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Address(int addressId, String houseNo, String colony, String city, String state, int pincode) {
		super();
		this.addressId = addressId;
		this.houseNo = houseNo;
		this.colony = colony;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}


	public int getAddressId() {
		return addressId;
	}


	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}


	public String getHouseNo() {
		return houseNo;
	}


	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}


	public String getColony() {
		return colony;
	}


	public void setColony(String colony) {
		this.colony = colony;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public int getPincode() {
		return pincode;
	}


	public void setPincode(int pincode) {
		this.pincode = pincode;
	}


	

	
	
	
	
	


	
	

}
