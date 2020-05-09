package com.capgemini.admin.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.admin.dao.RawMaterialOrderDetailsRepository;
import com.capgemini.admin.dao.RawMaterialStockRepository;
import com.capgemini.admin.dao.SupplierDetailsRepository;
import com.capgemini.admin.dao.UserRepository;
import com.capgemini.admin.entities.RawMaterialOrderDetails;
import com.capgemini.admin.entities.RawMaterialStock;
import com.capgemini.admin.entities.SupplierDetails;
import com.capgemini.admin.entities.Userdata;

@Service
public class AdminServiceImplementation implements AdminServiceInterface {
	
	@Autowired
	UserRepository urepo;
	
	@Autowired
	RawMaterialStockRepository rmrepo;
	
	@Autowired
	RawMaterialOrderDetailsRepository rorepo;
	
	@Autowired
	SupplierDetailsRepository srepo;
	

	@Override
	public Userdata addUser(Userdata user) {
		
		return urepo.save(user);
	}

	@Override
	public String loginUser(Userdata u) {
	
		 String flag="null";
		   	
	    	String usertype=urepo.findByusertype(u.getUsername(),u.getUserpassword());
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
	public RawMaterialStock addRawMaterialStock(RawMaterialStock r) {
		
		return rmrepo.save(r);
	}

	@Override
	public List<RawMaterialStock> viewRawMaterialStock() {
		
		return rmrepo.findAll();
	}

	
	
	
	@Override
	public RawMaterialOrderDetails addRawMaterialOrderDetails(RawMaterialOrderDetails rmo) {
		
		int quan = rmo.getQuantityUnit();
		double unit = rmo.getPricePerUnit();
		rmo.setTotalPrice(quan*unit);
		
		
		Date dateofOrder = new Date();
		Date dateofOrder1 = new Date(dateofOrder.getTime());
		rmo.setOrderDate(dateofOrder1);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateofOrder);
		cal.add(Calendar.DATE,4);
		Date modifiedDate  = cal.getTime();
		Date dateofdel = new Date(modifiedDate.getTime());
		rmo.setDeliveryDate(dateofdel);
		

		rmo.setDeliveryStatus("Not dispatched");
		
		return rorepo.save(rmo);
	}

	@Override
	public Optional<RawMaterialOrderDetails> viewRawMaterialOrderDetailsById(int orderId) {
		
		return rorepo.findById(orderId);
	}

	@Override
	public List<RawMaterialOrderDetails> viewRawMaterialOrderDetails() {
		
		return rorepo.findAll();
	}

	
	
	
	@Override
	public SupplierDetails addSupplierDetails(SupplierDetails s) {
		
		return srepo.save(s);
	}

	@Override
	public Optional<SupplierDetails> viewSupplierDetailsById(int supplierId) {
		
		return srepo.findById(supplierId);
	}

	@Override
	public List<SupplierDetails> viewSupplierDetails() {
		
		return srepo.findAll();
	}

}
