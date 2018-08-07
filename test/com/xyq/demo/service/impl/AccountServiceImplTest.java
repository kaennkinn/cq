package com.xyq.demo.service.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xyq.demo.service.AccountService;

public class AccountServiceImplTest {

	static ApplicationContext context;
	
	private AccountService accountService = null;
	
	@BeforeClass
	public static void InitContext() {
		context = new ClassPathXmlApplicationContext("applicationContext.xml","applicationContext2.xml");
		
	}
	
	@Before
	public void init() {
		accountService = context.getBean(AccountService.class);
	}
	
	@Test
	public void testBuyStock() {
		int result = accountService.buyStock(1.5D, 0L, 1, 1);
		System.out.println(result);
	}
    
	@Test
	public void testTransferMoney() {
		 accountService.transferMoney(1, 2, 10D);
	}
	
	@Test
	public void testSellStock() {
		fail("Not yet implemented");
	}

}
