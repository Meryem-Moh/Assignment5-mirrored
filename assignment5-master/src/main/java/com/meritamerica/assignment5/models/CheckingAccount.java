package com.meritamerica.assignment5.models;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;




public class CheckingAccount extends BankAccount{
	
// Variables are extended from super class
    
    //Constructors
	//Default
    public CheckingAccount(){
        super(0.00, 0.0001);
    }

    public CheckingAccount(double checkingB){
        super(checkingB, 0.0001);
    }
    
    //Needed
    public CheckingAccount(long accountNumber, double balance, double interestRate
    		, java.util.Date accountOpenedOn) {
    	super(accountNumber, balance, interestRate, accountOpenedOn);
    }



    //Methods

    
    public String toString(){
        DecimalFormat format = new DecimalFormat("##.00");
        return "\nAccount Balance: $" + format.format(this.getBalance()) + "\n"
                + "Account Interest Rate: " + this.getInterestRate() + "\n"
                + "Account Balance in 3 years: $" + format.format(this.futureValue(3));
    }
    
   
    
    static CheckingAccount readFromString(String accountData) {
    	try {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    	
    	String array1[] = accountData.split(",");
    	int fAccount = Integer.parseInt(array1[0]);
    	double fBalance = Double.parseDouble(array1[1]);
    	double fInterest = Double.parseDouble(array1[2]);
    	Date fDate = dateFormatter.parse(array1[3]);
    	
    	CheckingAccount checking = new CheckingAccount(fAccount, fBalance
    			, fInterest, fDate);
    	return checking;
    	} catch(ParseException e) {
    		return null;
    	}
}
    
    /*
     * Assignment 4 starts here
     */
   
}
