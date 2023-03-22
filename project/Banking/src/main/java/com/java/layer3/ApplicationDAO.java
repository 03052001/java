package com.java.layer3;

import java.util.List;

import com.java.layer2.Application;


public interface ApplicationDAO { 

	Application selectApplication(int ApplicationId);
	List<Application> selectAllApplication();
	
	void insertApplication(Application application);
	void updateApplication(Application application);
	void deleteApplication(int applicationId);

}
