package com.capgemini.customer.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "distributordetails")
public class DistributorDetails implements Serializable{
	@Id
	@Column(name ="distributor_id",length=7)
	private int distributorId;
	
	@Column(name = "distributor_name",length=15)
	private String distributorName;
	
	@Column(name = "address",length=50)
	private String address;
	
	@Column(name = "phone_number",length=12)
	private long phonenumber;
	
	@Column(name = "email_id",length=25)
	private String emailId;
	
	
	
	public DistributorDetails()
	{
		
	}



	public DistributorDetails(int distributorId, String distributorName, String address, long phonenumber,
			String emailId) {
		super();
		this.distributorId = distributorId;
		this.distributorName = distributorName;
		this.address = address;
		this.phonenumber = phonenumber;
		this.emailId = emailId;
	}



	public int getDistributorId() {
		return distributorId;
	}



	public void setDistributorId(int distributorId) {
		this.distributorId = distributorId;
	}



	public String getDistributorName() {
		return distributorName;
	}



	public void setDistributorName(String distributorName) {
		this.distributorName = distributorName;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public long getPhonenumber() {
		return phonenumber;
	}



	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}



	public String getEmailId() {
		return emailId;
	}



	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
}