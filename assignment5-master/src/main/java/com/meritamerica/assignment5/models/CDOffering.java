package com.meritamerica.assignment5.models;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class CDOffering {
	
	@Min(value  = 1 , message = "term size error too small")
	private int term;
	
	@DecimalMin(value = "0.0", inclusive = false , message = "interest rate size error too small")
	@Max(value = (long) 0.9999999999 , message = "interest rate size error too big")
	private double interestRate;
	
	public CDOffering() {
		
	}
	
	CDOffering(int term, double interestRate) {
		//constructs the CDOffering
		this.term = term;
		this.interestRate = interestRate;				
	}
	
	
	
	
	
	
	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	static CDOffering readFromString(String cdOfferingDataString) {
		
		CDOffering toBeAdded = null;
		try{
			String[] toBeParsed = cdOfferingDataString.split(",");
			int termToAdd = Integer.parseInt(toBeParsed[0]);
			double interestRateToBeAdded = Double.parseDouble(toBeParsed[1]);
			
			toBeAdded = new CDOffering(termToAdd , interestRateToBeAdded);
			
			
			
			
		}catch(NumberFormatException exception) {
			throw exception;		
		}
		
		return toBeAdded;
		
	}
	
	
	public String writeToString() {
		StringBuilder cdoStringBuilder = new StringBuilder(term + "," + interestRate);
		String toString = cdoStringBuilder.toString();
		return toString;
		
	}

	
	
	
}
