package com.dev;

public class Account {
	// 계좌정보, 예금주, 예금액
	
	//field
	private String accNO;
	private String accName;
	private int money;
	
	// constructor(생성자). 목적은 필드의 초기값을 지정
	public Account(String accNO, String accName, int money) {
		super();
		this.accNO = accNO;
		this.accName = accName;
		this.money = money;
	}
	
	// method
	public String getAccNO() {
		return accNO;
	}
	
	public void setAccNO(String accNO) {
		this.accNO = accNO;
	}
	public String getAccName() {
		return accName;
	}
	public void setAccName(String accName) {
		this.accName = accName;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "Account [accNO=" + accNO + ", accName=" + accName + ", money=" + money + "]";
	}
	
	
	
}
