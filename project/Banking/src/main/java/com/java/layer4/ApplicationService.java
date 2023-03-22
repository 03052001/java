package com.java.layer4;

import java.util.List;

import com.java.layer2.Application;

public interface ApplicationService {
	void saveApplicationService(Application application) throws ApplicationAlreadyExistsException;
	void modifyApplicationService(Application application) throws ApplicationNotFoundException;
	void removeApplicationService(int applicationId) throws ApplicationNotFoundException;
	

	int findApplicationService(int applicationId) throws ApplicationNotFoundException;
	List<Application> findAllApplicationService();
	
	}
