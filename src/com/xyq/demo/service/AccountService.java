package com.xyq.demo.service;

public interface AccountService {

	/**
	 * 
	 * @param cost 每股单价
	 * @param stockCount 购买股票数量
	 * @param bid 银行账户id
	 * @param sid 股票账户id
	 * @return
	 */
	public int buyStock(Double cost,Long stockCount,Integer bid,Integer sid);
	/**
	 * 
	 * @param cost 每股单价
	 * @param stockCount 购买股票数量
	 * @param bid 银行账户id
	 * @param sid 股票账户id
	 * @return
	 */
	public int sellStock(Double cost,Long stockCount,Integer bid,Integer sid);
	/**
	 * @param from_bid 转账id
	 * @param to_bid 收账id
	 * @param money 转账金额
	 * @return
	 */
	public int transferMoney(int from_bid,int to_bid,Double money);
}
