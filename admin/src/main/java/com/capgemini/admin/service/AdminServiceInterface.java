package com.capgemini.admin.service;

import java.util.List;
import java.util.Optional;

import com.capgemini.admin.entities.RawMaterialOrderDetails;
import com.capgemini.admin.entities.RawMaterialStock;
import com.capgemini.admin.entities.SupplierDetails;
import com.capgemini.admin.entities.Userdata;



public interface AdminServiceInterface {
	
	 Userdata addUser(Userdata user);
	
	 String loginUser(Userdata u);
	
	 RawMaterialStock addRawMaterialStock(RawMaterialStock r);
	
     List<RawMaterialStock> viewRawMaterialStock();
	
	 RawMaterialOrderDetails addRawMaterialOrderDetails( RawMaterialOrderDetails rmo);

	 Optional<RawMaterialOrderDetails> viewRawMaterialOrderDetailsById(int orderId);
	 
	 List<RawMaterialOrderDetails> viewRawMaterialOrderDetails();
	 
	 SupplierDetails addSupplierDetails(SupplierDetails s); 
		
	 Optional<SupplierDetails> viewSupplierDetailsById(int supplierId);
		
     List<SupplierDetails> viewSupplierDetails();

}
