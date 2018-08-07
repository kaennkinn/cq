package com.xyq.demo.dao;

import java.util.List;

import com.xyq.demo.entity.BankAccount;

public interface BankAccountDao {
	
	public int addBankAccount(BankAccount bankAccount);
	
	public int deleteBankAccount(BankAccount bankAccount);
	
	public int modifyBankAccount(BankAccount bankAccount);
	
	public BankAccount findBankAccountById(Integer bid);
	
	public List<BankAccount> findAllBankAccount();
}
