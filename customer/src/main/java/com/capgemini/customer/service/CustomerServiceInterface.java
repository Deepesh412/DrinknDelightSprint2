package com.capgemini.customer.service;

import java.util.List;
import java.util.Optional;

import com.capgemini.customer.entities.DistributorDetails;
import com.capgemini.customer.entities.ProductOrderDetails;
import com.capgemini.customer.entities.ProductStock;
import com.capgemini.customer.entities.Userdata;


public interface CustomerServiceInterface {

	 Userdata addUser(Userdata user);
	 
	 String loginUser(Userdata u);
	 
	 ProductStock addProductStock(ProductStock p); 
	 
	 List<ProductStock> viewProductStock();
	 
	 ProductOrderDetails addProductOrderDetails(ProductOrderDetails po); 
	 
	 Optional<ProductOrderDetails> viewProductOrderDetailsById(int orderId);
	 
	 List<ProductOrderDetails> viewProductOrderDetails();
	 
	 DistributorDetails addDistributorDetails(DistributorDetails distributordetails);
	 
	 Optional<DistributorDetails> viewDistributorDetailsById(int distributorId);

	 List<DistributorDetails> viewDistributorDetails();
}
