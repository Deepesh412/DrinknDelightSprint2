package com.capgemini.admin.controller;

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

import com.capgemini.admin.entities.RawMaterialOrderDetails;
import com.capgemini.admin.entities.RawMaterialStock;
import com.capgemini.admin.entities.SupplierDetails;
import com.capgemini.admin.entities.Userdata;
import com.capgemini.admin.exceptions.IdNotFoundException;
import com.capgemini.admin.exceptions.UnsuccessfulOrderException;
import com.capgemini.admin.service.AdminServiceInterface;


@RestController
@RequestMapping("/admin")
@CrossOrigin("http://localhost:4200")
public class AdminController {
	
	@Autowired
	AdminServiceInterface service;
	
	
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
	 		
	 		 String flag=service.loginUser(u);
	 		 return flag;
	 	}
	  
	  
	  @PostMapping(value = "/addrawmaterialstock")
		public RawMaterialStock addRawMaterialStock (@RequestBody RawMaterialStock r)
		{
			return service.addRawMaterialStock(r);		
		}
		
		
		@GetMapping(value="/getallrawmaterials",produces="application/json")
	    public List<RawMaterialStock> viewRawMaterialStock()
	    {
	   	 return service.viewRawMaterialStock();
	    }
		
		
		@PostMapping(value = "/placerawmaterialorder")
		public ResponseEntity<String> addRawMaterialOrderDetails(@RequestBody RawMaterialOrderDetails rmo)
		{	
			RawMaterialOrderDetails raw = service.addRawMaterialOrderDetails(rmo);
			if(raw == null) {
				throw new UnsuccessfulOrderException("Unsuccessful in creating order");
			}
			else
			{
				return new ResponseEntity<String>("placed orders successfully",new HttpHeaders(),HttpStatus.OK);
			}
		}
	    
		
		@GetMapping(value="/getrawmaterialorderdetails/{orderId}",produces="application/json")
	    public Optional<RawMaterialOrderDetails> viewRawMaterialOrderDetails(@PathVariable int orderId)
	    {
	   	 return service.viewRawMaterialOrderDetailsById(orderId);
	    }
		
		
		@GetMapping(value="/getallrawmaterialorderdetails",produces="application/json")
	    public List<RawMaterialOrderDetails> viewRawMaterialOrderDetails()
	    {
	   	 return service.viewRawMaterialOrderDetails();
	    }
	
	
	        
	     @PostMapping(value = "/addsupplierdetails")
	 	public SupplierDetails addSupplierDetails (@RequestBody SupplierDetails s)
	 	{
	 		return service.addSupplierDetails(s);		
	 	}
	 	
	 	@GetMapping(value="/getsuppierdetails/{supplierId}",produces="application/json")
	     public Optional<SupplierDetails> viewSupplierDetails(@PathVariable int supplierId)
	     {
	    	 return service.viewSupplierDetailsById(supplierId);
	     }
	 	
	 	@GetMapping(value="/getallsupplierdetails",produces="application/json")
	     public List<SupplierDetails> viewSupplierDetails()
	     {
	    	 return service.viewSupplierDetails();
	     }    
		
		
	

}
