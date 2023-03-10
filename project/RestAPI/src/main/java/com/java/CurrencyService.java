package com.java;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/currency")
public class CurrencyService {
	
	public CurrencyService() {
		System.out.println("Currency Service called");
	}

	@GET
	@Path("/greet")
	public String welcome() {
		return"<h1> Welcome to web based services </h1>";
	}
	
	@GET
	@Path("/convert")
	@Produces(MediaType.APPLICATION_JSON)
	public Currency convert() {
		
		Currency curr=new Currency();
		curr.setCurrencyId(1);
		curr.setSourceCurrency("USD");
		curr.setTargetCurrency("INR");
		curr.setAmountToConvert(500);
		
		return curr;
	}
	
	
	@GET
	@Path("/converts")
	@Produces(MediaType.APPLICATION_JSON)
	public Currency convertAll() {
		
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
		
		List<Currency>currList= ArrayList<Currency>();
		currList.add(curr1);
		currList.add(curr2);
		currList.add(curr3);
		
		
		
		return currList;
	}
	@GET
	@Path("/greet2")
	public String welcome2() {
		return"<h1> Welcome2 to web based services </h1>";
	}
}
