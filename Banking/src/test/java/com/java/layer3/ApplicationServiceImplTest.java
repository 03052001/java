package com.java.layer3;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.java.layer2.Application;
import com.java.layer4.ApplicationAlreadyExistsException;
import com.java.layer4.ApplicationNotFoundException;
import com.java.layer4.ApplicationService;
import com.java.layer4.ApplicationServiceImpl;


public class ApplicationServiceImplTest {

	ApplicationService appService = new ApplicationServiceImpl();

	
	@Test public void applicationAddTest() {Application application = new Application();
	//application.setApplicationId(1);
		application.setApplicantName("Ras");
		application.setFathername(" Rghava");
		application.setGender("f");
		application.setMobileNumber("9421225080");
		application.setEmailID("shreyas@gmail.com");
		application.setAdhaarNumber("624329072090");
		application.setDateOFBirth("2000-03-05");
		application.setApplicantStatus("PENDING");
			
		try {appService.saveApplicationService(application);
		} catch (ApplicationAlreadyExistsException e) {
			System.out.println("Error : "+e);
		}
		
	}
	@Test public void applicationDeleteTest() {Application application = new Application();
	
	try {appService.removeApplicationService(15);;
	} catch (ApplicationNotFoundException e) {
		System.out.println("Error : "+e);
	}
	
}
    @Test
    public void findAllApplication(){
    	ApplicationService application = new ApplicationServiceImpl();
                System.out.println("testing finding all application..");
                               List<Application> listApplication  =application.findAllApplicationService();
                              for (Application application1 : listApplication) {
                                             System.out.println("Application :"+ application1);
                             }
               
    }
    @Test public void findApplicationTest()  {
		
	
		/*
		 * try {List<Application> application =appService.findApplicationService(6); }
		 * catch (ApplicationNotFoundException e) { System.out.println("Error : "+e); }
		 * System.out.println("app: "+listApplication);
		 */
    	Application app=null;
    	try {
			app=appService.findApplicationService(6);
			System.out.println(app);
		} catch (ApplicationNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
}
    
    

	
	
	
	@Test public void applicationModifyTest()
	{
	Application application = new Application();
	application.setApplicationId(3);
	application.setApplicantName("RA");
	application.setFathername("Rakesh");
	application.setGender("M");
	application.setMobileNumber("9480482135");
	application.setEmailID("ram@gmail.com");
	application.setAdhaarNumber("200649175842");
	application.setDateOFBirth("2020-05-03");
	application.setApplicantStatus("PENDING");
	
	try {appService.modifyApplicationService(application);
	} catch (ApplicationNotFoundException e) {
		System.out.println("Error : "+e);
	}
	
}
}