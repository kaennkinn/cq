package com.xyq.demo.service.impl;

import static org.junit.Assert.assertTrue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xyq.demo.dao.BankAccountDao;
import com.xyq.demo.dao.StockAccountDao;
import com.xyq.demo.entity.BankAccount;
import com.xyq.demo.entity.StockAccount;
import com.xyq.demo.service.AccountService;
@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	private BankAccountDao bankAccountDao;
	
	@Autowired
	private StockAccountDao stockAccountDao;
	@Override
	public int buyStock(Double cost, Long stockCount, Integer bid, Integer sid) {
		
		BankAccount bankAccount = bankAccountDao.findBankAccountById(bid);
		
		if( bankAccount!= null ) {
			if( bankAccount.getMoney() >= cost) {
				Double balance = bankAccount.getMoney()-(cost*stockCount);
				bankAccount.setMoney(balance);
				int result = bankAccountDao.modifyBankAccount(bankAccount);
				if( result>0 ) {
					StockAccount stockAccount = stockAccountDao.findStockAccountById(sid);
					if (stockAccount!=null) {
						stockAccount.setCount(stockAccount.getCount()+stockCount);
						int stockResult = stockAccountDao.modifyStockAccount(stockAccount);
						if (stockResult>0) {
							
							return 0;
						} else {
							//22:股票账户更新失败
							return 22;
						}
					} else {
						//20:股票账户不存在
						return 20;
					}
					
				} else {
					//12:银行账户更新失败
					return 12;
				}
			} else {
				//11:账户余额不足
				return 11;
			}
		} else {
			//10:账户不存在
			return 10;
		}
		
	}

	@Override
	public int sellStock(Double cost, Long stockCount, Integer bid, Integer sid) {
		
		return 0;
	}

	/**
	 * @param from_bid 转账id
	 * @param to_bid 收账id
	 * @param money 转账金额
	 * @return
	 */
//	@Transactional(readOnly=true,noRollbackFor=ArithmeticException.class)
	@Override
	public int transferMoney(int from_bid, int to_bid, Double money) {
		BankAccount bankAccount = new BankAccount();
		bankAccount.setBid(3);
		bankAccount.setBname("hh");
		bankAccount.setMoney(200D);
		bankAccountDao.addBankAccount(bankAccount);
		//查询银行账户是否存在
		BankAccount bankAccount_from = bankAccountDao.findBankAccountById(from_bid);
		BankAccount bankAccount_to = bankAccountDao.findBankAccountById(to_bid);
		if(bankAccount_from != null && bankAccount_to != null) {
			Double balance = bankAccount_from.getMoney();
			if ((balance-money)<0) {
				return 10;
			}else {
				bankAccount_from.setMoney(balance-money);
				//更新转账人账户余额
				bankAccountDao.modifyBankAccount(bankAccount_from);
				int i = 1/0;
				//更新收账人账户余额
				bankAccount_to.setMoney(bankAccount_to.getMoney()+money);
				bankAccountDao.modifyBankAccount(bankAccount_to);
			}
		}
		return 0;
	}

}
