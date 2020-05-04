package com.meritamerica.assignment5.models;

public class MeritAmericaBankApp {
	public static void main(String[] args) throws ExceedsCombinedBalanceLimitException {
		
		MeritBank.readFromFile("src/test/testMeritBank_good.txt");
	
	//CheckingAccount chk1 = new CheckingAccount(280000);	
	//SavingsAccount sav1 = new SavingsAccount(250000);
	//SavingsAccount sav2 = new SavingsAccount(100000);
	CDOffering cdoff1 = new CDOffering(2, 0.1);
	CDAccount cdacc1 = new CDAccount(cdoff1, 100000);
	
	System.out.println(MeritBank.recursiveFutureValue(1000, 4, 0.01));
	
	
	//AccountHolder ah1 = new AccountHolder();
	//AccountHolder ah2 = new AccountHolder();
	AccountHolder ah3 = new AccountHolder();
	//ah1.addCheckingAccount(chk1);
//	System.out.println(ah1.addCheckingAccount(chk1));
//	System.out.println(ah2.addSavingsAccount(sav1));
//	System.out.println(ah2.addSavingsAccount(sav2));
//	
	//System.out.println(ah3.addCDAccount(cdacc1));
	
	
	
	}
}