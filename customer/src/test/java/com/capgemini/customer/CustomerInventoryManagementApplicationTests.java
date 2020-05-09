package com.capgemini.customer;

import static org.junit.Assert.assertEquals;

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

import com.capgemini.customer.dao.DistributorDetailsRepository;
import com.capgemini.customer.dao.ProductOrderDetailsRepository;
import com.capgemini.customer.dao.ProductStockRepository;
import com.capgemini.customer.dao.UserRepository;
import com.capgemini.customer.entities.DistributorDetails;
import com.capgemini.customer.entities.ProductOrderDetails;
import com.capgemini.customer.entities.ProductStock;
import com.capgemini.customer.entities.Userdata;
import com.capgemini.customer.service.CustomerServiceImplementation;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class CustomerInventoryManagementApplicationTests {

	@Mock
	private UserRepository ur;
	@Mock
	private DistributorDetailsRepository dr;
	@Mock
	private ProductOrderDetailsRepository podr;
	@Mock
	private ProductStockRepository ps;


	@InjectMocks
	CustomerServiceImplementation service;

	@Before
	public void init() {
	MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testAddUser() {
	Userdata ud = new Userdata();
	ud.setUserid(15);
	ud.setUsername("rama");
	ud.setUsertype("customer");
	ud.setUserpassword("rama26");
	ud.setUserphone(1909056909);
	service.addUser(ud);
	Mockito.verify(ur,Mockito.times(1)).save(ud);
	}
	
	@Test
	public void testAddProductStock() throws java.text.ParseException {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		Date d = sdf1.parse("2020-04-01");
		Date d2 = sdf1.parse("2020-04-06");
	
		DistributorDetails dis = new DistributorDetails();
	    dis.setDistributorId(12);
	    dis.setDistributorName("deepesh");
	    dis.setAddress("asmangadh");
	    dis.setPhonenumber(1999999999);
	    dis.setEmailId("deepesh@gmail.com");
		
		ProductStock pro = new ProductStock(12,"grapes",50,d,d2,dis);
		service.addProductStock(pro);
		Mockito.verify(ps,Mockito.times(1)).save(pro);	
	}
	
	@Test
	public void testListProductStock()throws java.text.ParseException {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		Date d = sdf1.parse("2020-04-01");
		Date d2 = sdf1.parse("2020-04-06");
		
		DistributorDetails dis = new DistributorDetails();
	    dis.setDistributorId(12);
	    dis.setDistributorName("deepesh");
	    dis.setAddress("asmangadh");
	    dis.setPhonenumber(1999999999);
	    dis.setEmailId("deepesh@gmail.com");
	    
	    List<ProductStock> prolist = new ArrayList<>();
		prolist.add(new ProductStock(12,"sprite",50,d,d2,dis));
		prolist.add(new ProductStock(13,"pepsi",55,d,d2,dis));
		prolist.add(new ProductStock(14,"lassi",60,d,d2,dis));
		
        Mockito.when(ps.findAll()).thenReturn(prolist);
		
		List<ProductStock> returnedData = ps.findAll();
		assertEquals(3,returnedData.size());  
	}
	
	@Test
	public void testAddProductOrderDetails() throws java.text.ParseException {
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
	Date d = sdf1.parse("2020-03-15");
	Date d2 = sdf1.parse("2020-04-20");

	ProductOrderDetails pod = new ProductOrderDetails();

		pod.setOrderId(12);
		pod.setProductId(23);
		pod.setDistributorId(14);
		pod.setItemName("sprite");
		pod.setPricePerUnit(20);
		pod.setQuantityUnit(2);
		pod.setTotalPrice(40);
		pod.setOrderDate(d);
		pod.setDeliveryDate(d2);   
		pod.setDeliveryStatus("not dispatched");
	    service.addProductOrderDetails(pod);
		Mockito.verify(podr,Mockito.times(1)).save(pod);
	    
	}
	
	@Test
	public void testviewProductOrderDetails() throws java.text.ParseException {
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
	Date d = sdf1.parse("2020-03-15");
	Date d2 = sdf1.parse("2020-04-05");

	List<ProductOrderDetails> rawList = new ArrayList<>();
	rawList.add(new ProductOrderDetails(13,12,23,"mango",20.0,3,60.0,d,d2,"not dispatched"));
	rawList.add(new ProductOrderDetails(14,13,24,"grapes",20.0,3,60.0,d,d2,"not dispatched"));
	rawList.add(new ProductOrderDetails(15,14,25,"gauva",20.0,3,60.0,d,d2,"not dispatched"));

	Mockito.when(podr.findAll()).thenReturn(rawList);

	List<ProductOrderDetails> returnedData = podr.findAll();
	assertEquals(3,returnedData.size());
	}
	
	@Test
	public void testaddDistributorDetails()
	{
	    DistributorDetails dd = new DistributorDetails();
	    dd.setDistributorId(18);
	    dd.setDistributorName("ram");
	    dd.setAddress("hyd");
	    dd.setPhonenumber(1999946991);
	    dd.setEmailId("ram54@gamil.com");
	    service.addDistributorDetails(dd);
	    Mockito.verify(dr,Mockito.times(1)).save(dd);
	 }
	
	@Test
	public void testviewDistributorDetails()
	{
	    List<DistributorDetails>distlist = service.viewDistributorDetails();
	    distlist.add(new DistributorDetails(18,"ram","hyd",1999946999,"ram54@gmail.com"));
	    distlist.add(new DistributorDetails(12,"munna","chennai",1999199999,"munna4@gmail.com"));
	   
	    Mockito.when(dr.findAll()).thenReturn(distlist);
	   
	    List<DistributorDetails> returnedData = dr.findAll();
	    assertEquals(2,returnedData.size());

	}

}
