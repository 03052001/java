package com.java;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


	@Path("/registration")
	public class RegistrationProcess {
	
		
	
	
		
		
		
		static List<Registration>regList=  new ArrayList<Registration>();
		
		static {
			Registration reg1=new Registration();
			reg1.setName("Shriharsha k");
			reg1.setDateOfBirth("03/05/2001");
			reg1.setEmailId("shriharsha.k2001@mail.com");
			reg1.setPhoneNo(948341080);
			reg1.setUserName("skk142");
			reg1.setPassword("skk@030");
			reg1.setConfirmPassword("skk@030");
			reg1.setAddress("Padmashree house ,ilanthila post and village");
			reg1.setCardtype(" Gold Type");
			reg1.setBank("Sbi");
			reg1.setSavingsAccountNo(584220064);
			reg1.setIfscCode("Sbin014");
			
			Registration reg2=new Registration();
			reg2.setName("Mukhil k");
			reg2.setDateOfBirth("03/05/2001");
			reg2.setEmailId("shriharsha.k2001@mail.com");
			reg2.setPhoneNo(948341080);
			reg2.setUserName("skk142");
			reg2.setPassword("skk@030");
			reg2.setConfirmPassword("skk@030");
			reg2.setAddress("Padmashree house ,ilanthila post and village");
			reg2.setCardtype(" Gold Type");
			reg2.setBank("Sbi");
			reg2.setSavingsAccountNo(444220064);
			reg2.setIfscCode("Sbin014");
			
			Registration reg3=new Registration();
			reg3.setName("Svomoy k");
			reg3.setDateOfBirth("03/05/2001");
			reg3.setEmailId("shriharsha.k2001@mail.com");
			reg3.setPhoneNo(948341080);
			reg3.setUserName("skk142");
			reg3.setPassword("skk@030");
			reg3.setConfirmPassword("skk@030");
			reg3.setAddress("Padmashree house ,ilanthila post and village");
			reg3.setCardtype(" Gold Type");
			reg3.setBank("Sbi");
			reg3.setSavingsAccountNo(124220064);
			reg3.setIfscCode("Sbin014");
			
			
			
			regList.add(reg1);
			regList.add(reg2);
			regList.add(reg3);
			
		}
		public RegistrationProcess() {
			
		}
		
		
		@GET
		@Path("/registers/{cid}")
		@Produces(MediaType.APPLICATION_JSON)
		public Registration convertIt(@PathParam("cid") long x) {
			
			Registration reg=null;
			for(Registration registratio :regList) {
				if(registratio.getSavingsAccountNo()==x) {
					reg=registratio;
					break;
				}
			}
			
			return reg;
		}
		@POST
		@Path("/add")
		@Produces(MediaType.APPLICATION_JSON)
		public String addIt(Registration regObj) {
			
	       		
			boolean found=false;
			
			Registration reg=null;
			for(Registration  registratio :regList) {
				if(registratio.getSavingsAccountNo()==regObj.getSavingsAccountNo()) {
					
					found=true;
					break;
				}
			}
			if (found==true)
			return "User already exists";
			else {
				regList.add(regObj);
				return "User added";
				
			}
		}
		@DELETE
		@Path("/delete/{cid}")
		@Produces(MediaType.APPLICATION_JSON)
		public String deleteIt(@PathParam("cid") long x) {
			
			
			boolean found=false;
			
			Registration reg=null;
			for(Registration registratio :regList) {
				if(registratio.getSavingsAccountNo()==x) {
					reg=registratio;
					regList.remove(reg);
					found=true;
					break;
				}
			}
			if (found==true)
			return "User deleted";
			else return"User Not Found:"+x;
		}
		@PUT
		@Path("/update")
		@Produces(MediaType.APPLICATION_JSON)
		public String modifyIt(Registration regObj) {
			
	       		
			boolean found=false;
			
			Currency curr=null;
			for(Registration registratio :regList) {
				if(registratio.getSavingsAccountNo()==regObj.getSavingsAccountNo()) {
					
					found=true;
					
					regList.remove(registratio);
					break;
				}
			}
			if (found==true) {
				regList.add(regObj);
			return "User modified";
			}
			else {
				
				return "User not found";
				
			}
		}
		@GET
		@Path("/getAllRegistrations")
		@Produces(MediaType.APPLICATION_JSON)
		public List<Registration> registrationAll() {
			
			return  regList;
		}
	}
	
	
		

