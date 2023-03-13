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

@Path("/currency")
public class CurrencyService {
	
	
	
	static List<Currency>currList=  new ArrayList<Currency>();
	
	static {
		Currency curr1=new Currency();
		curr1.setCurrencyId(1);
		curr1.setSourceCurrency("USD");
		curr1.setTargetCurrency("INR");
		curr1.setAmountToConvert(500);
		
		Currency curr2=new Currency();
		curr2.setCurrencyId(2);
		curr2.setSourceCurrency("EUR");
		curr2.setTargetCurrency("INR");
		curr2.setAmountToConvert(600);
		
		Currency curr3=new Currency();
		curr3.setCurrencyId(3);
		curr3.setSourceCurrency("DIN");
		curr3.setTargetCurrency("INR");
		curr3.setAmountToConvert(700);
		
		
		
		currList.add(curr1);
		currList.add(curr2);
		currList.add(curr3);
	}
	
	public CurrencyService() {
		
		
		
		
		System.out.println("Currency Service called");
	}

	@GET
	@Path("/greet")
	public String welcome() {
		return
			"<h1> Welcome to web based services </h1>";
		
	}
	
	@GET
	@Path("/convert/{cid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Currency convertIt(@PathParam("cid") int x) {
		
		Currency curr=null;
		for(Currency currency :currList) {
			if(currency.getCurrencyId()==x) {
				curr=currency;
				break;
			}
		}
		
		return curr;
	}
	
	@DELETE
	@Path("/delete/{cid}")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteIt(@PathParam("cid") int x) {
		
		
		boolean found=false;
		
		Currency curr=null;
		for(Currency currency :currList) {
			if(currency.getCurrencyId()==x) {
				curr=currency;
				currList.remove(curr);
				found=true;
				break;
			}
		}
		if (found==true)
		return "Currency deleted";
		else return"Currency Not Found:"+x;
	}
	
	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public String addIt(Currency currObj) {
		
       		
		boolean found=false;
		
		Currency curr=null;
		for(Currency currency :currList) {
			if(currency.getCurrencyId()==currObj.getCurrencyId()) {
				
				found=true;
				break;
			}
		}
		if (found==true)
		return "Currency already exists";
		else {
			currList.add(currObj);
			return "Currency added";
			
		}
	}
	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	public String modifyIt(Currency currObj) {
		
       		
		boolean found=false;
		
		Currency curr=null;
		for(Currency currency :currList) {
			if(currency.getCurrencyId()==currObj.getCurrencyId()) {
				
				found=true;
				
				currList.remove(currency);
				break;
			}
		}
		if (found==true) {
			currList.add(currObj);
		return "Currency modified";
		}
		else {
			
			return "Currency not found";
			
		}
	}
	
	
	@GET
	@Path("/converts")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Currency> convertAll() {
		
		return   currList;
	}
	
	@GET
	@Path("/greet2")
	public String welcome2() {
		return"<h1> Welcome2 to web based services </h1>";
	}
}
                                                                             
  

















