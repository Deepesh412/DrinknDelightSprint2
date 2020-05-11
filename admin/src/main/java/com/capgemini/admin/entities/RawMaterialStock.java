package com.capgemini.admin.entities;

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
@Table(name = "rawmaterialstock")
public class RawMaterialStock implements Serializable {
	
	@Id
	@Column(name = "raw_material_id",length=7)
	private int rawmaterialId;
	
	@Column(name = "item_name",length=15)
	private String itemName;
	
	@Column(name = "price_per_unit",length=5)
	private double pricePerUnit;
	
	@Column(name="manufacturing_date",length=11)
	private Date manufacturingDate;
	
	@Column(name="expiry_date",length=11)
	private Date expiryDate;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="supplierdetails", referencedColumnName="supplier_id")
	private SupplierDetails supplierDetails;
	
public RawMaterialStock() {
		
	}

public RawMaterialStock(int rawmaterialId, String itemName, double pricePerUnit, Date manufacturingDate,
		Date expiryDate, SupplierDetails supplierDetails) {
	super();
	this.rawmaterialId = rawmaterialId;
	this.itemName = itemName;
	this.pricePerUnit = pricePerUnit;
	this.manufacturingDate = manufacturingDate;
	this.expiryDate = expiryDate;
	this.supplierDetails = supplierDetails;
}

public int getRawmaterialId() {
	return rawmaterialId;
}

public void setRawmaterialId(int rawmaterialId) {
	this.rawmaterialId = rawmaterialId;
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

public SupplierDetails getSupplierDetails() {
	return supplierDetails;
}

public void setSupplierDetails(SupplierDetails supplierDetails) {
	this.supplierDetails = supplierDetails;
}
    

    
}

