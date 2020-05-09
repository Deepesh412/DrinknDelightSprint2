package com.capgemini.customer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.customer.entities.DistributorDetails;
import com.capgemini.customer.entities.ProductOrderDetails;
import com.capgemini.customer.entities.ProductStock;
import com.capgemini.customer.entities.Userdata;
import com.capgemini.customer.exceptions.IdNotFoundException;
import com.capgemini.customer.exceptions.UnsuccessfulOrderException;
import com.capgemini.customer.service.CustomerServiceInterface;

@RestController
@RequestMapping("/customer")
@CrossOrigin("http://localhost:4200")
public class CustomerController {
	
	@Autowired
	CustomerServiceInterface service;
	
	 @PostMapping(value="/adduser")
     public ResponseEntity<String> addUser(@RequestBody Userdata user)
     {
    	 Userdata  e= service.addUser(user);
    		if (e == null) {
    			throw new IdNotFoundException("Enter Valid Id");
    		} else {
    			return new ResponseEntity<String>("User created successfully", new HttpHeaders(), HttpStatus.OK);
    		}
     }
	 
	 @PutMapping("/login")
	 public String loginUser(@RequestBody Userdata u)
	 	{
	 		
	 		 String flag = service.loginUser(u);
	 		 return flag;
	 	}
	 
	 
	 @PostMapping(value = "/addproductstock")
	 public ProductStock addProductStock (@RequestBody ProductStock p)
		{
			return service.addProductStock(p);
		}
		
		
	 @GetMapping(value="/getallproducts",produces="application/json")
	 public List<ProductStock> viewProductStock()
	    {
	   	 return service.viewProductStock();
	    }

	 
	 @PostMapping(value = "/placeproductorderdetails")
	 public ResponseEntity<String> addProductOrderDetails(@RequestBody ProductOrderDetails po)
		{
			ProductOrderDetails pro = service.addProductOrderDetails(po);
			if(pro == null) {
				throw new UnsuccessfulOrderException("unsuccessful in creating order");
			}
			else
			{
				return new ResponseEntity<String>("placed order successfully",new HttpHeaders(),HttpStatus.OK);
			}
		}
		
		
	@GetMapping(value="/getproductorderdetails/{orderId}",produces="application/json")
	public Optional<ProductOrderDetails> viewProductOrderDetails(@PathVariable int orderId)
	    {
	   	 return service.viewProductOrderDetailsById(orderId);
	    }
		
		
   @GetMapping(value="/getallproductorderdetails",produces="application/json")
   public List<ProductOrderDetails> viewProductOrderDetails()
	    {
	   	 return service.viewProductOrderDetails();
	    }
		
	
	
	@PostMapping(value = "/adddistributordetails")
	public DistributorDetails addDistributorDetails (@RequestBody DistributorDetails distributordetails)
	{
		return service.addDistributorDetails(distributordetails);		
	}
	
	@GetMapping(value="/getdistributordetails/{distributorId}",produces="application/json")
    public Optional<DistributorDetails> viewDistributorDetails(@PathVariable int distributorId)
    {
   	 return service.viewDistributorDetailsById(distributorId);
    }
	
	@GetMapping(value="/getalldistributordetails",produces="application/json")
    public List<DistributorDetails> viewDistributorDetails()
    {
   	 return service.viewDistributorDetails();
    }

}
