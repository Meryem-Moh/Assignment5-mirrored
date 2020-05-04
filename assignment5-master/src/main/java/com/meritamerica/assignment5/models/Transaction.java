package com.meritamerica.assignment5.models;

import java.util.Date;

public abstract class Transaction {
	
	private Date date;
	private  long sourceAccount;
	private long targetAccount;
	private double amount;
	
	public Transaction() {
		
	}
	
	public Transaction(Date date, long sourceAccount,long targetAccount, double amount) {
		this.date= date;
		this.sourceAccount =sourceAccount;
		this.targetAccount = targetAccount;
		this.amount = amount;
	}	
	
	
	public BankAccount getSourceAccount() {
		return this.getSourceAccount();
		
	}
	
	public void setSourceAccount() {
		this.setSourceAccount();
	}

	public BankAccount getTargetAccount() {
		return this.getTargetAccount();
	}
	
	public void setTagetAccount() {
		this.setSourceAccount();
		
	}
	public double getAmount() {
		return this.getAmount();
	}
	public void setAmount(double amount) {
		this.setAmount(amount);
	}
	public Date getTransactionDate() {
		return this.getTransactionDate();
		
	}
	
	public void setTransacionDate(Date date) {
		this.setTransacionDate(date);
		
	}
	public String writeToString() {
		return this.toString();
		
	}
	
	////Work on it
//	public static Transaction readFromString(String transactionDataString) {
		
		
	//return 
	//}
	
	
	
	
	
	
	
	

}
