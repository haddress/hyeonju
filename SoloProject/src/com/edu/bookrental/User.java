package com.edu.bookrental;

public class User {

	private String id;
	private String pw;
	private String phone;

	public User() {

	}

	public User(String id, String pw, String phone) {
		super();
		this.id = id;
		this.pw = pw;
		this.phone = phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String toInfo() {
		return "\tID: " + id + "\n" + "\tPHONE: " + phone;
	}

}
