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
		application.setApplicationId(5);	
		try {appService.saveApplicationService(application);
		} catch (ApplicationAlreadyExistsException e) {
			System.out.println("Error : "+e);
		}
		
	}
	@Test public void applicationDeleteTest() {Application application = new Application();
	
	try {appService.removeApplicationService(5);;
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
    @Test public void findApplicationTest() throws  ApplicationNotFoundException {Application application = new Application();
		
	appService.findApplicationService(6);
	System.out.println("Application:"+application);
}
    
    

	
	
	
	@Test public void applicationModifyTest()
	{
	Application application = new Application();
	application.setApplicationId(4);
	application.setApplicantName("RAM");
	application.setFathername("Rakesh");
	application.setGender("M");
	application.setMobileNumber("9480481135");
	application.setEmailID("ram@gmail.com");
	application.setAdhaarNumber("200649075842");
	application.setDateOFBirth("2020-05-03");
	application.setApplicantStatus("PENDING");
	
	try {appService.modifyApplicationService(application);
	} catch (ApplicationNotFoundException e) {
		System.out.println("Error : "+e);
	}
	
}
}