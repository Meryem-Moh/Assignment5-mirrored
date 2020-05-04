package com.meritamerica.assignment5.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meritamerica.assignment5.models.AccountHolder;
import com.meritamerica.assignment5.models.BankAccount;
import com.meritamerica.assignment5.models.CDAccount;
import com.meritamerica.assignment5.models.CDOffering;
import com.meritamerica.assignment5.models.CheckingAccount;
import com.meritamerica.assignment5.models.ExceedsCombinedBalanceLimitException;
import com.meritamerica.assignment5.models.MeritBank;
import com.meritamerica.assignment5.models.SavingsAccount;
import com.meritamerica.assignment5.models.Transaction;

@RestController
public class AccountHolderController {
	
	
	@RequestMapping (value ="/AccountHolders", method = RequestMethod.POST)
		public AccountHolder postAccounHolder(AccountHolder accHolder) {
		accHolder = new AccountHolder();
		if (accHolder.getFirstName()== null || accHolder.getMiddleName()==null ||
				accHolder.getLastName() == null) {
			System.out.println("Bad Request! Please Try Again!");
		}	
		else {
		MeritBank.addAccountHolder(accHolder);
		System.out.println("Successfully Added!");
		}
		
		return accHolder;
	}
	
	@RequestMapping(value="/AccountHolders", method = RequestMethod.GET)
	public AccountHolder[] getAccountHolders () {
		 AccountHolder accHoldersList[] = new AccountHolder[1];
		accHoldersList=MeritBank.getAccountHolders();
		System.out.println("Successfully Retrived!!");
		return accHoldersList;
		
		
	}
	
	//Not completed
	@GetMapping(value= "/AccountHolders/{id}")
	public AccountHolder getAccountHolder(long id) {
		AccountHolder accHolder = new AccountHolder();
		long idList = MeritBank.getNextAccountNumber();
		if(idList != id) {
			System.out.println("Account Holder Not Found!");
			
		}
		else {
			System.out.println("Matched Successfully" );
			System.out.println(idList);
			
			
		}
		return accHolder;
			
	}	
		
		@PostMapping(value= "/AccountHolders/{id}/CheckingAccounts")
		public CheckingAccount postCheckingAccount(double openingBalance) throws ExceedsCombinedBalanceLimitException {
		
			double checkingBalance;
			double savingBalance;
			double totBalance;
			CheckingAccount checkingAccount= new CheckingAccount();
		//	SavingsAccount savingAccount = new SavingsAccount();
			AccountHolder accHolder = new AccountHolder();
			checkingBalance = accHolder.getCheckingBalance();
			savingBalance = accHolder.getSavingsBalance();
			totBalance = checkingBalance + savingBalance + openingBalance;
			
			
		try {
			if (openingBalance <=0  ) {
				System.out.println("The request cant be processed!");
			}
			if(totBalance > 250000) {
				System.out.println("Sorry request cannot be processed!");
			}
		
		}catch(Exception e) {
			
		}
			
		
		return checkingAccount;
					
		}

		
		@GetMapping(value="/AccountHolders/{id}/CheckingAccounts")
		public CheckingAccount[] getCheckingAccounts(@PathVariable int id) {
			
			AccountHolder accHolder = new AccountHolder();
			
			return accHolder.getCheckingAccounts();
			
			
		}	
		

		@PostMapping(value="/AccountHolders/{id}/SavingsAccounts")
		public SavingsAccount postSavingAccount(double openingBalance) {
			double checkingBalance;
			double savingBalance;
			double totBalance;
			SavingsAccount savingAccount= new SavingsAccount();
		//	SavingsAccount savingAccount = new SavingsAccount();
			AccountHolder accHolder = new AccountHolder();
			checkingBalance = accHolder.getCheckingBalance();
			savingBalance = accHolder.getSavingsBalance();
			totBalance = checkingBalance + savingBalance + openingBalance;
			
			
		try {
			if (openingBalance <=0  ) {
				System.out.println("The request cant be processed!");
			}
			if(totBalance > 250000) {
				System.out.println("Sorry request cannot be processed!");
			}
		
		}catch(Exception e) {
			
		}
			
		
		return savingAccount;
		}
	
	
	
	
	
	
		@GetMapping(value="/AccountHolders/{id}/SavingsAccounts")
		public SavingsAccount[] getSavingsAccounts(long id) {
			AccountHolder accHolder = new AccountHolder();
		//	SavingsAccount savings = new SavingsAccount();
			long accountid=0;
		if(	MeritBank.getBankAccount(accountid) != id) {
			System.out.println("Account Holder doesnt exist!");
			
		}
			
			return accHolder.getSavingsAccounts();
			
		}
	
	
		@PostMapping(value="/AccountHolders/{id}/CDAccounts") 
		public CDAccount postCDAccounts(int id) {
			double balance=0;
			AccountHolder accHolder = new AccountHolder();
			CDOffering offering = new CDOffering();
			CDAccount cdAccount = new CDAccount(offering, balance);
			
			return accHolder.addCDAccount(cdAccount);
			
			
		}
	


	@GetMapping(value="/AccountHolders/{id}/CDAccounts")
	public CDAccount[] getCDAccounts(@PathVariable  int id) {
		AccountHolder accHolder = new AccountHolder();
		 return accHolder.getCDAccounts();
	}
	
	
	
	
}
