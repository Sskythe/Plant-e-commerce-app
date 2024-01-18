package com.cg.nursery.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin_tbl")
public class Admin {
	
	@Id
	private int adminid;
	@Column(length=30)
	private String adminUserName;
	@Column(length=30)
	private String adminPassword;
	
	public Admin() {
		super();
	}

	public Admin(int adminid, String adminUserName, String adminPassword) {
		super();
		this.adminid = adminid;
		this.adminUserName = adminUserName;
		this.adminPassword = adminPassword;
	}

	public int getAdminid() {
		return adminid;
	}

	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}

	public String getAdminUserName() {
		return adminUserName;
	}

	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	@Override
	public String toString() {
		return "Admin [adminid=" + adminid + ", adminUserName=" + adminUserName + ", adminPassword=" + adminPassword
				+ "]";
	}
	
	
	
	

	

}
