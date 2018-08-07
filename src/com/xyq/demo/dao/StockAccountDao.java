package com.xyq.demo.dao;

import java.util.List;

import com.xyq.demo.entity.StockAccount;

public interface StockAccountDao {

	public int addStockAccount(StockAccount sAccount);
	
	public int delStockAccount(StockAccount sAccount);
	
	public int modifyStockAccount(StockAccount sAccount);
	
	public StockAccount findStockAccountById(Integer sid);
	
	public List<StockAccount> findAllStockAccount();
}
