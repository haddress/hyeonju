package com.dev;

public class repeat {
	
	private String accNO;
	private String accName;
	private int money;
	
	public repeat(String accNO, String accName, int money) {
		super();
		this.accNO = accNO;
		this.accName = accName;
		this.money = money;
		
	}

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
	
	

}
