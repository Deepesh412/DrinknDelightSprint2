package com.capgemini.admin.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "supplierdetails")
public class SupplierDetails implements Serializable {
	
	@Id
	@Column(name ="supplier_id",length=7)
	private int supplierId;
	
	@Column(name = "supplier_name",length=15)
	private String supplierName;
	
	@Column(name = "address",length=50)
	private String address;
	
	@Column(name = "phone_number",length=12)
	private long phonenumber;
	
	@Column(name = "email_id",length=25)
	private String emailId;
    
	public SupplierDetails() {
	}

	public SupplierDetails(int supplierId, String supplierName, String address, long phonenumber, String emailId) {
		super();
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.address = address;
		this.phonenumber = phonenumber;
		this.emailId = emailId;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
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
