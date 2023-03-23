package com.java.layer3;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.java.layer2.Application;


public class DAOImplTest {

	

	@Test
	public void testAllApplication()
	{
		System.out.println("started DAO testing...");
		
		ApplicationDAO appDao = new ApplicationDAOImpl();
		
	Assertions.assertTrue(appDao!=null);
		
		List<Application> appList=appDao.selectAllApplication();
	Assertions.assertTrue(appList.size() > 0 );
		
		for (Application application : appList) {
			System.out.println("Application : "+application);
		}
	
	}
	
	@Test
	public void testLoadSingleApplication()
	{
		System.out.println("started DAO testing...");
		
		ApplicationDAO appDao = new ApplicationDAOImpl();
		
	Assertions.assertTrue(appDao!=null);
		
		Application app=appDao.selectApplication(12);
	Assertions.assertTrue(app!=null );
		
		System.out.println("application : "+app);
	
	}
	
	@Test
	public void testAddSingleApplication()
	{
		System.out.println("started DAO testing...");
		
		ApplicationDAO appDao = new ApplicationDAOImpl();	
	Assertions.assertTrue(appDao!=null);
		
		Application app=new Application();
	Assertions.assertTrue(app!=null);
	
		
	app.setApplicantName("R");
	app.setFathername(" Rghava");
	app.setGender("M");
	app.setMobileNumber("9449220872");
	app.setEmailID("shreyas@gmail.com");
	app.setAdhaarNumber("084249072017");
	app.setDateOFBirth("2000-03-05");
	app.setApplicantStatus("PENDING");
		
		System.out.println("Application : "+app);
		appDao.insertApplication(app);
		System.out.println("Application added....");
	}
	
	@Test
	public void testUpdateSingleApplication()
	{
		System.out.println("started DAO testing...");
		
		ApplicationDAO appDao = new ApplicationDAOImpl();	
	Assertions.assertTrue(appDao!=null);
		
		Application app=new Application();
	Assertions.assertTrue(app!=null);
	
		app.setApplicationId(3);
		app.setApplicantName("Shriharsha  k");
		app.setFathername(" K Shridhar Bhat");
		app.setGender("M");
		app.setMobileNumber("9483410805");
		app.setEmailID("shk@gmail.com");
		app.setAdhaarNumber("584220069407");
		app.setDateOFBirth("2001-03-05");
		app.setApplicantStatus("PENDING");
		
		System.out.println("Application : "+app);
		appDao.updateApplication(app);
		System.out.println("application updated....");
	}
	
	@Test
	public void testDeleteSingleApplication()
	{
		System.out.println("started DAO testing...");
		
		ApplicationDAO appDao = new ApplicationDAOImpl();	
	Assertions.assertTrue(appDao!=null);
		
		appDao.deleteApplication(2);
		System.out.println("Application deleted....");
	}

}
