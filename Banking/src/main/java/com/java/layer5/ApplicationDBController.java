      package com.java.layer5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.java.layer2.Application;

import com.java.layer4.ApplicationAlreadyExistsException;
import com.java.layer4.ApplicationNotFoundException;
import com.java.layer4.ApplicationService;
import com.java.layer4.ApplicationServiceImpl;


@Path("/applicationdb") 
public class ApplicationDBController {	
	ApplicationService applicationService = new ApplicationServiceImpl();
	
	public ApplicationDBController() { System.out.println("Application Service called...");}

	
	
	@DELETE @Path("/delete/{id}")
	public String deleteIt(@PathParam("id") int x, Application appObj) {
		try {
			applicationService.removeApplicationService(x);
			return "Application deleted successfully";
		} catch (ApplicationNotFoundException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
		
		
		
	}
	@POST 
	@Path("/add")
	public String addIt(Application appObj) {
		
		try {
			applicationService.saveApplicationService(appObj);
			return "Application added successfully";

		} catch (ApplicationAlreadyExistsException e) {
			return e.getMessage();
		}
	}
	
	
	@PUT 
	@Path("/edit")
	public String modifyIt(Application appObj) {
		
		try {
			applicationService.modifyApplicationService(appObj);
			return "Application modified successfully";

		} catch (ApplicationNotFoundException e) {
			return e.getMessage();
		}
	}
	
	
	@GET
	@Path("/getall")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Application> getall() {
		
		
			return applicationService.findAllApplicationService();
			
	}
	

	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Application findIt(@PathParam("id") int x, Application appObj) {
		try {
			applicationService.findApplicationService(x);
			return applicationService.findApplicationService(x);
		} catch (ApplicationNotFoundException e) {
			// TODO Auto-generated catch block
					}
		return appObj;
}
}
