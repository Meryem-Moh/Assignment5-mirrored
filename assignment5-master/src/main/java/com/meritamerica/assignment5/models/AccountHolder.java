package com.meritamerica.assignment5.models;

import java.text.DecimalFormat;


public class AccountHolder implements Comparable<AccountHolder>{
	// implements Comparable interface
    private String firstName;
    private String middleName;
    private String lastName;
    private String ssn;
    public CheckingAccount checking[] = new CheckingAccount[1];
    public SavingsAccount savings[] = new SavingsAccount[1];
    public CDAccount cdAccount[] = new CDAccount[1];


    // Constructors
    public AccountHolder() {
        this.firstName = "Meryem";
        this.middleName = "Nuredin";
        this.lastName = "Mohammed";
        this.ssn = " ";
    }

    public AccountHolder(String firstname, String middlename, String lastname, String ssn){
        this.firstName = firstname;
        this.middleName = middlename;
        this.lastName = lastname;
        this.ssn = ssn;
    }

    // Setters and Getters
    public void setFirstName(String firstname){
        this.firstName = firstname;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public void setMiddleName(String middlename){
        this.middleName = middlename;
    }

    public String getMiddleName(){
        return this.middleName;
    }

    public void setLastName(String lastname){
        this.lastName = lastname;
    }

    public String getLastName(){
        return this.lastName;
    }

    public void setSSN(String ssn){
        this.ssn = ssn;
    }

    public String getSSN(){
        return this.ssn;
    }

    // Methods

//Assignment 4 starts here
    public CheckingAccount addCheckingAccount(double openingBalance) throws ExceedsCombinedBalanceLimitException{
        double totBalance = 0;
        double totChecking = 0;
        double totSaving = 0;
        totChecking = this.getCheckingBalance();
        totSaving = this.getSavingsBalance();
        double addOpening = openingBalance;
        totBalance = totChecking + totSaving + addOpening;    // adds the opening balance

        if (totBalance > 250000){
     	   System.out.println("Exceeds the Combained Balance Limit Exception!");
     //	   throw new ExceedsCombinedBalanceLimitException();
     	   return checking[checking.length - 1];
        }
     	  else {   
     	   checking[checking.length - 1] = new  CheckingAccount(openingBalance);
            checking[checking.length - 1].setAccountNumber(MeritBank.getNextAccountNumber());
             CheckingAccount arrayTemp[] = new CheckingAccount[checking.length + 1];
             for(int x = 0; x < checking.length; x++) {
             	arrayTemp[x] = checking[x];
             }
             
             checking = arrayTemp;
             return checking[checking.length - 2]; 
        }
     }
     
     
     //For Checking Account
     public CheckingAccount addCheckingAccount(CheckingAccount checkingAccount) throws ExceedsCombinedBalanceLimitException{
        double totBalance = 0;
        double totChecking = 0;
        double totSaving = 0;
        totChecking = this.getCheckingBalance();
        totSaving = this.getSavingsBalance();
        double addChecking = checkingAccount.getBalance();
        totBalance = totChecking + totSaving + addChecking;  // adds checkingAccount obj 
        
        if (totBalance > 250000){
     	   System.out.println("Exceeds the Combined Balance Limit Exception!");
     	   return checking[checking.length - 1];
        }
     	    else {

         	   checking[checking.length - 1] = checkingAccount;
                checking[checking.length - 1].setAccountNumber(MeritBank.getNextAccountNumber());
                CheckingAccount arrayTemp[] = new CheckingAccount[checking.length + 1];
                for(int x = 0; x < checking.length; x++) {
               	arrayTemp[x] = checking[x];
                }
                checking = arrayTemp;
                return checking[checking.length - 2];
            }
     	   }
     	  
        

    public CheckingAccount[] getCheckingAccounts(){
        return this.checking;
    }

    public int getNumberOfCheckingAccounts(){
        return this.checking.length - 1;
    }

    public double getCheckingBalance(){
        double totBalance = 0;
        for(int x = 0; x < checking.length - 1; x++){
            totBalance += checking[x].getBalance();
        }
        return totBalance;
    }

  //For Savings Account
    public SavingsAccount addSavingsAccount(double openingBalance) throws ExceedsCombinedBalanceLimitException {
    	double totBalance;
    	double totChecking;
    	double totSaving;
    	totChecking = this.getCheckingBalance();
    	totSaving = this.getSavingsBalance();
    	double addOpening = openingBalance;
    	totBalance = totChecking + totSaving + addOpening;
    	
    		   if(totBalance > 250000) {
    			   System.out.println("Exceeds the Combined Balance Limit Exception!");
                   return savings[savings.length - 1];
    	   }
    	   else {
    		   savings[savings.length - 1] = new SavingsAccount(openingBalance);
             savings[savings.length - 1].setAccountNumber(MeritBank.getNextAccountNumber());
            SavingsAccount arrayTemp[] = new SavingsAccount[savings.length + 1];
             for(int x = 0; x < savings.length; x++) {
             	arrayTemp[x] = savings[x];
            }
            savings = arrayTemp;
             return savings[savings.length - 2];
    		   }
    	   }
    
    
    
    public SavingsAccount addSavingsAccount(SavingsAccount savingsAccount)throws ExceedsCombinedBalanceLimitException {
	       double totBalance = 0;
	       double totChecking = 0;
	       double totSaving = 0;
	       totChecking = this.getCheckingBalance();
	       totSaving = this.getSavingsBalance();
	       double addSavings = savingsAccount.getBalance();
	        totBalance = totChecking + totSaving + addSavings;
	           if (totBalance > 250000){
	          System.out.println("Unable to Complete Action, Combined Balance exceeds the Limit Exception!");
	         return savings[savings.length - 1];
	      } else {
	      	savings[savings.length - 1] = savingsAccount;
	      	savings[savings.length - 1].setAccountNumber(MeritBank.getNextAccountNumber());
	          SavingsAccount arrayTemp[] = new SavingsAccount[savings.length + 1];
	          for(int x = 0; x < savings.length; x++) {
	         	arrayTemp[x] = savings[x];
	          }
	          savings = arrayTemp;
	         return savings[savings.length - 2];
	      }
	  }
   
    	   

    public SavingsAccount[] getSavingsAccounts(){
        return this.savings;
    }

    public int getNumberOfSavingsAccounts(){
        return this.savings.length - 1;
    }

    public double getSavingsBalance(){
        double totBalance = 0;
        for(int x = 0; x < savings.length - 1; x++){
            totBalance += savings[x].getBalance();
        }
        return totBalance;
    }


//    CDAccount
    public CDAccount  addCDAccount (CDOffering offering , double openingBalance) {
    	 
  	  cdAccount[cdAccount.length -1] = new CDAccount(offering, openingBalance);
  	  cdAccount[cdAccount.length - 1].setAccountNumber(MeritBank.getNextAccountNumber());   // adds the next acct no(i.e openingBalance)
  	  CDAccount tempArray[] = new CDAccount[cdAccount.length +1];
  	  for(int i=0; i <cdAccount.length; i++) {
  		  tempArray[i] = cdAccount[i];
  	  }cdAccount =tempArray;
  	  return cdAccount[cdAccount.length - 2];
  	  }
    
    public CDAccount addCDAccount(CDAccount cdAccount1) {
        
	      if(cdAccount.equals(null)) {
	    	  System.out.println("Unable to complete transaction!");
	    	  return null;
	      }
	      cdAccount[cdAccount.length -1] = cdAccount1;
	      cdAccount[cdAccount.length -1].setAccountNumber(MeritBank.getNextAccountNumber());  //adds the cdAccount
	      CDAccount tempArray[] = new CDAccount[cdAccount.length +1];// bigger size
	      for(int i= 0; i< cdAccount.length; i++) {
	    	  tempArray[i] = cdAccount[i];
	      }
	      cdAccount = tempArray;
	      return this.cdAccount[cdAccount.length - 2];
    }
  

    public CDAccount[] getCDAccounts(){
        return this.cdAccount;
    }

    public int getNumberOfCDAccounts(){
        return this.cdAccount.length - 1;
    }

    public double getCDBalance(){
        double totBalance = 0;
        for(int x = 0; x < this.cdAccount.length - 1; x++) {
            totBalance += cdAccount[x].getBalance();
        }
        return totBalance;
    }

    public double getCombinedBalance(){
        double totBalance;
        totBalance = this.getCheckingBalance();
        totBalance += this.getSavingsBalance();
        totBalance += this.getCDBalance();
        return totBalance;
    }

    public String toString(){
        DecimalFormat format = new DecimalFormat("##.00");
        return "Name: " + this.firstName + " " + this.middleName + " " + this.lastName + "\n"
                + "SSN: " + this.ssn + "\n";
    }
    
    @Override
    public int compareTo(AccountHolder otherAccount) {
    	if(this.getCombinedBalance() > otherAccount.getCombinedBalance()) {
    		return 1;
    	} else
    		return -1;
    }
    
    public String writeToString() {
    	return this.lastName + "," + this.middleName + "," + this.firstName + ","
    			+ this.ssn;
    }
    
    static AccountHolder readFromString(String accountData) {
    	String array1[] = accountData.split(",");
    	try {
    	AccountHolder ah = new AccountHolder(array1[2], array1[1]
    			, array1[0], array1[3]);
    	return ah;
    	} catch (Exception e) {
    		return null;
    	}
    }

   
   
   
       
    
    	   
     
      
     
    
    
      } 
       
       
       
       
       
       
       
       
       
       
      
       



























