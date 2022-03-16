package com.prod;

public class User {
	private int userId;
	private String userGrade;
	private String userPhone;
	private int userPoint;
	
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getUserId() {
		return this.userId;
	}


	public void setUserGrade(String userGrade) {
		this.userGrade = userGrade;
	}
	
	public String getUserGrade() {
		return this.userGrade;
	}
	
	
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	
	public String getUserPhone() {
		return this.userPhone;
	}
	
	
	public void setUserPoint(int userPoint) {
		this.userPoint = userPoint;
	}
	
	public int getUserPoint() {
		return this.userPoint;
	}
	
	
	public String getUserInfo() {
		String result = this.userId + " 고객님의 등급은 " + this.userGrade //
				+ "이고 등록되신 전화번호는 " + this.userPhone //
				+ "이며, 현재 보유중이신 포인트는 " + this.userPoint //
				+ "점 입니다.";
		return result;
	}
	
	
	
	

}
