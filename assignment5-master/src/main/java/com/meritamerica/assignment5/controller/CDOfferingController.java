package com.meritamerica.assignment5.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meritamerica.assignment5.models.CDOffering;

@RestController
public class CDOfferingController {
	
	List<CDOffering> cdOfferings = new ArrayList<CDOffering>();

	
	@PostMapping(value= "/CDOfferings")
	public CDOffering postCDOffering(CDOffering offering) {
		
		cdOfferings.add(offering);
		return offering;
				
	}
	 
	@GetMapping(value="/CDOfferings")
	public List<CDOffering> getCDOfferings(){
		return cdOfferings;
		
	}
	
	
	
	
	
	
	

}
