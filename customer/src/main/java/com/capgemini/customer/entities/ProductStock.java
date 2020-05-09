package com.capgemini.customer.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "productstock")
public class ProductStock implements Serializable{
	
	@Id
	@Column(name = "product_id")
	private int productId;
	
	@Column(name = "item_name")
	private String itemName;
	
	@Column(name = "price_per_unit")
	private double pricePerUnit;
	
	@Column(name="manufacturing_date")
	private Date manufacturingDate;
	
	@Column(name="expiry_date")
	private Date expiryDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="distributordetails", referencedColumnName="distributor_id")
	private DistributorDetails distributorDetails;
	
	
    public ProductStock()  {

    }


	public ProductStock(int productId, String itemName, double pricePerUnit, Date manufacturingDate, Date expiryDate,
			DistributorDetails distributorDetails) {
		super();
		this.productId = productId;
		this.itemName = itemName;
		this.pricePerUnit = pricePerUnit;
		this.manufacturingDate = manufacturingDate;
		this.expiryDate = expiryDate;
		this.distributorDetails = distributorDetails;
	}


	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public double getPricePerUnit() {
		return pricePerUnit;
	}


	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}


	public Date getManufacturingDate() {
		return manufacturingDate;
	}


	public void setManufacturingDate(Date manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}


	public Date getExpiryDate() {
		return expiryDate;
	}


	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}


	public DistributorDetails getDistributorDetails() {
		return distributorDetails;
	}


	public void setDistributorDetails(DistributorDetails distributorDetails) {
		this.distributorDetails = distributorDetails;
	}


	
}