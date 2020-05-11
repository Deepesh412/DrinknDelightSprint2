package com.capgemini.customer.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "productorderdetails")
public class ProductOrderDetails implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "orderId_Sequence")
	@SequenceGenerator(name = "orderId_Sequence", sequenceName = "order_id_SEQ")
	@Column(name = "order_id",length=7)
	private int orderId;

	@Column(name = "product_id",length=7)
	private int productId;
	
	@Column(name = "distributor_id",length=7)
	private int distributorId;
	
	@Column(name = "item_name",length=15)
	private String itemName;
	
	@Column(name = "price_per_unit",length=7)
	private double pricePerUnit;

	@Column(name = "quantity_unit",length=7)
	private int quantityUnit;
	
	@Column(name = "total_price",length=9)
	private double totalPrice;
	
	@Column(name = "order_date",length=11)
	private Date orderDate;
	
	@Column(name = "delivery_date",length=11)
	private Date deliveryDate;
	
	@Column(name = "delivery_status",length=15)
	private String deliveryStatus;

	
	public ProductOrderDetails()
	{
		
	}


	public ProductOrderDetails(int orderId, int productId, int distributorId, String itemName, double pricePerUnit,
			int quantityUnit, double totalPrice, Date orderDate, Date deliveryDate, String deliveryStatus) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.distributorId = distributorId;
		this.itemName = itemName;
		this.pricePerUnit = pricePerUnit;
		this.quantityUnit = quantityUnit;
		this.totalPrice = totalPrice;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.deliveryStatus = deliveryStatus;
	}


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public int getDistributorId() {
		return distributorId;
	}


	public void setDistributorId(int distributorId) {
		this.distributorId = distributorId;
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


	public int getQuantityUnit() {
		return quantityUnit;
	}


	public void setQuantityUnit(int quantityUnit) {
		this.quantityUnit = quantityUnit;
	}


	public double getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}


	public Date getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}


	public Date getDeliveryDate() {
		return deliveryDate;
	}


	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}


	public String getDeliveryStatus() {
		return deliveryStatus;
	}


	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}


	
}


