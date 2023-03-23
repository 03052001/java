package com.java.layer4;

import java.util.List;

import com.java.layer2.Application;
import com.java.layer3.ApplicationDAO;
import com.java.layer3.ApplicationDAOImpl;

public class ApplicationServiceImpl implements ApplicationService {

	ApplicationDAO appDao = new ApplicationDAOImpl();
	
	

	public void saveApplicationService(Application applicationToAdd) throws ApplicationAlreadyExistsException
	{
		List<Application> listApplications = appDao.selectAllApplication();
		boolean applicationFound=false;	
		for (Application application : listApplications) {
			if(application.getApplicationId()== applicationToAdd.getApplicationId()) {
					applicationFound=true;	break;
			} 
		}
		if(applicationFound==true)throw new ApplicationAlreadyExistsException("Application alreayd present");
		else appDao.insertApplication(applicationToAdd);
	}
	
	public void modifyApplicationService(Application applicationToModify) throws ApplicationNotFoundException
	{
		List<Application> listApplications = appDao.selectAllApplication();
		boolean applicationFound=false;	
		for (Application application : listApplications) {
			if(application.getApplicationId() == applicationToModify.getApplicationId() ) {
					applicationFound=true;	
					break;
			} 
		}
		if(applicationFound==false)throw new ApplicationNotFoundException("Application Not present");
		else appDao.updateApplication(applicationToModify);
	}

	public void removeApplicationService(int applicationIdtoremove) throws ApplicationNotFoundException {
		List<Application> listApplications = appDao.selectAllApplication();
		boolean applicationFound=false;	
		for (Application application : listApplications) {
			if(application.getApplicationId() == applicationIdtoremove ) {
					applicationFound=true;	
					break;
			} 
		}
		if(applicationFound==false)throw new ApplicationNotFoundException("Application Not present");
		else appDao.deleteApplication( applicationIdtoremove);
	}

	
	public Application findApplicationService(int applicationId) throws ApplicationNotFoundException 
	{
		 List<Application> listApplication = appDao.selectAllApplication();
		 Application app=null;
		 boolean applicationFound=false;	
			for (Application application : listApplication) {
				if(application.getApplicationId() == applicationId) {
						applicationFound=true;	
						break;
				} 
		
			}
			if(applicationFound==true) app=appDao.selectApplication(applicationId);
			else throw new ApplicationNotFoundException("Application Not present");
			return app;
			
			
	};
    public List<Application> findAllApplicationService() {
        List<Application> listApplication = appDao.selectAllApplication();
      return listApplication ;
}
	
}


