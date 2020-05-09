package com.capgemini.customer.service;


import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.customer.dao.DistributorDetailsRepository;
import com.capgemini.customer.dao.ProductOrderDetailsRepository;
import com.capgemini.customer.dao.ProductStockRepository;
import com.capgemini.customer.dao.UserRepository;
import com.capgemini.customer.entities.DistributorDetails;
import com.capgemini.customer.entities.ProductOrderDetails;
import com.capgemini.customer.entities.ProductStock;
import com.capgemini.customer.entities.Userdata;

@Service
public class CustomerServiceImplementation implements CustomerServiceInterface {
	
	@Autowired
	UserRepository urepo;
	
	@Autowired
	ProductStockRepository psrepo;
	
	@Autowired
	ProductOrderDetailsRepository porepo;
	
	@Autowired
	DistributorDetailsRepository drepo;

	@Override
	public Userdata addUser(Userdata user) {
		
		return urepo.save(user);
	}

	@Override
	public String loginUser(Userdata u) {
       
		String flag = "null";
	
		String usertype = urepo.findByusertype(u.getUsername(), u.getUserpassword());
		if(usertype.equalsIgnoreCase("admin"))
		{
			return "admin";
		}
		else if(usertype.equalsIgnoreCase("customer"))
		{
			return "customer";
		}
		else
			
		return "invalid";
	}

	@Override
	public ProductStock addProductStock(ProductStock p) {
		
		return psrepo.save(p);
	}

	@Override
	public List<ProductStock> viewProductStock() {
		
		return psrepo.findAll();
	}

	@Override
	public ProductOrderDetails addProductOrderDetails(ProductOrderDetails po) {
		
	
        	int quan = po.getQuantityUnit();
        	double uniprice = po.getPricePerUnit();
        	po.setTotalPrice(quan*uniprice);
        	
        	Date dateofOrder = new Date();
        	Date dateofOrder1 = new Date(dateofOrder.getTime());
        	po.setOrderDate(dateofOrder1);
        	
        	Calendar cal = Calendar.getInstance();
        	cal.setTime(dateofOrder);
        	cal.add(Calendar.DATE,4);
        	Date modifiedDate = cal.getTime();
        	Date dateofdel = new Date(modifiedDate.getTime());
        	po.setDeliveryDate(dateofdel);
        	
        	po.setDeliveryStatus("Not dispatched");
      
		return porepo.save(po);
	}

	@Override
	public Optional<ProductOrderDetails> viewProductOrderDetailsById(int orderId) {
	
		return porepo.findById(orderId);
	}

	@Override
	public List<ProductOrderDetails> viewProductOrderDetails() {
	
		return porepo.findAll();
	}

	
	@Override
	public DistributorDetails addDistributorDetails(DistributorDetails distributordetails) {
		
		return drepo.save(distributordetails);
	}

	@Override
	public Optional<DistributorDetails> viewDistributorDetailsById(int distributorId) {
		
		return drepo.findById(distributorId);
	}

	@Override
	public List<DistributorDetails> viewDistributorDetails() {
		
		return drepo.findAll();
	}

}
