package com.capgemini.admin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.admin.dao.RawMaterialOrderDetailsRepository;
import com.capgemini.admin.dao.RawMaterialStockRepository;
import com.capgemini.admin.dao.SupplierDetailsRepository;
import com.capgemini.admin.dao.UserRepository;
import com.capgemini.admin.entities.RawMaterialOrderDetails;
import com.capgemini.admin.entities.RawMaterialStock;
import com.capgemini.admin.entities.SupplierDetails;
import com.capgemini.admin.entities.Userdata;
import com.capgemini.admin.service.AdminServiceImplementation;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class AdminInventoryManagementApplicationTests {

	@Mock
	private UserRepository ur;
	@Mock
	private SupplierDetailsRepository sr;
	@Mock
	private RawMaterialOrderDetailsRepository rmos;
	@Mock
	private RawMaterialStockRepository rs;
	
	
	@InjectMocks
	AdminServiceImplementation service;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testAddUser() {
		Userdata ud = new Userdata();
		ud.setUserid(12);
		ud.setUsername("deepesh");
		ud.setUsertype("admin");
		ud.setUserpassword("deepesh26");
		ud.setUserphone(1909090909);
		service.addUser(ud);
		Mockito.verify(ur,Mockito.times(1)).save(ud);	
	}
	
	@Test
	public void testAddRawMaterialStock() throws java.text.ParseException {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		Date d = sdf1.parse("2020-04-01");
		Date d2 = sdf1.parse("2020-04-06");
		
		SupplierDetails supp = new SupplierDetails();
		supp.setSupplierId(1);
		supp.setSupplierName("deepesh");
		supp.setAddress("asmangadh");
		supp.setPhonenumber(1999999999);
		supp.setEmailId("deepesh@gmail.com");
		
		RawMaterialStock raw = new RawMaterialStock(12,"grapes",50,d,d2,supp);
		service.addRawMaterialStock(raw);
		Mockito.verify(rs,Mockito.times(1)).save(raw);
	}
	
	
	@Test
	public void testListRawMaterialStock() throws java.text.ParseException{ 
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		Date d = sdf1.parse("2020-04-01");
		Date d2 = sdf1.parse("2020-04-06");
		
		SupplierDetails supp = new SupplierDetails();
		supp.setSupplierId(1);
		supp.setSupplierName("deepesh");
		supp.setAddress("asmangadh");
		supp.setPhonenumber(1999999999);
		supp.setEmailId("deepesh@gmail.com");
		
		List<RawMaterialStock> rawlist = new ArrayList<>();
		rawlist.add(new RawMaterialStock(12,"grapes",50,d,d2,supp));
		rawlist.add(new RawMaterialStock(13,"mango",55,d,d2,supp));
		rawlist.add(new RawMaterialStock(14,"mango",60,d,d2,supp));
		
		Mockito.when(rs.findAll()).thenReturn(rawlist);
		
		List<RawMaterialStock> returnedData = rs.findAll();
		assertEquals(3,returnedData.size());
		
	}
	
	@Test
	public void testAddRawMaterialOrderDetails() throws java.text.ParseException {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		Date d = sdf1.parse("2020-04-01");
		Date d2 = sdf1.parse("2020-04-06");
		
		RawMaterialOrderDetails raw = new RawMaterialOrderDetails();
		raw.setOrderId(12);
		raw.setRawmaterialId(23);
		raw.setSupplierId(12);
		raw.setItemName("mango");
		raw.setPricePerUnit(20);
		raw.setQuantityUnit(2);
		raw.setTotalPrice(40);
		raw.setOrderDate(d);
		raw.setDeliveryDate(d2);
		raw.setDeliveryStatus("not dispatched");
		service.addRawMaterialOrderDetails(raw);
		Mockito.verify(rmos,Mockito.times(1)).save(raw);
	}
		
	@Test
	public void testviewRawMaterialOrderDetails() throws java.text.ParseException {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		Date d = sdf1.parse("2020-04-01");
		Date d2 = sdf1.parse("2020-04-05");
		
		List<RawMaterialOrderDetails> rawList = new ArrayList<>();
		rawList.add(new RawMaterialOrderDetails(13,12,23,"mango",20.0,3,60.0,d,d2,"not dispatched"));
		rawList.add(new RawMaterialOrderDetails(14,13,24,"grapes",20.0,3,60.0,d,d2,"not dispatched"));
		rawList.add(new RawMaterialOrderDetails(15,14,25,"gauva",20.0,3,60.0,d,d2,"not dispatched"));
		
		Mockito.when(rmos.findAll()).thenReturn(rawList);
		
		List<RawMaterialOrderDetails> returnedData = rmos.findAll();
		assertEquals(3,returnedData.size());		
	}
	
	@Test
	public void testaddSupplierDetails()
	{
		SupplierDetails s = new SupplierDetails();
		s.setSupplierId(12);
		s.setSupplierName("deepesh");
		s.setAddress("asmangadh");
		s.setPhonenumber(1999999991);
		s.setEmailId("deepeshmunna4@gamil.com");
		service.addSupplierDetails(s);
		Mockito.verify(sr, Mockito.times(1)).save(s);
    }
	
	/*@Test
	public void testviewSupplierDetailsById() {
		
		SupplierDetails sup = new SupplierDetails(123,"shravan","amberpet",1999999999,"deepesh@gmail.com");
		Mockito.when(sr.findById(123)).thenReturn(sup);
		
		SupplierDetails supde = service.viewSupplierDetailsById(123);
		assertEquals(supde,sup);
		assertEquals("shravan",supde.getSupplierName());
		assertNotEquals("xyz",supde.getSupplierName());
		
	}*/
	
	@Test
	public void testviewSupplierDetails()
	{
	     List<SupplierDetails>supplist = service.viewSupplierDetails();
	     supplist.add(new SupplierDetails(123,"deepesh","asmangadh",1999999999,"deepeshmunna4@gmail.com"));
	     supplist.add(new SupplierDetails(12,"munna","asmangadh",1999199999,"munna4@gmail.com"));
	     
	     Mockito.when(sr.findAll()).thenReturn(supplist);
	     
	     List<SupplierDetails> returnedData = sr.findAll();
	     assertEquals(2,returnedData.size());
	
	}
	
	
}
