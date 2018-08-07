package com.xyq.demo.entity;
/**
 * 银行账户类
 * @author xyq
 *
 */
public class BankAccount {

	private Integer bid;
	
	private String bname;
	
	private Double money;

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}
	
	
}
