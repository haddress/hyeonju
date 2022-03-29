package com.edu;

public class Member extends Object {
	// 필드---------------------------------------
	private int memberId;
	private String memberName;
	private String phone;
	// ------------------------------------------
	
	// 기본생성자-----------------------------------
	public Member() {
		
	}
	// ------------------------------------------

	// 생성자 (필드의 값을 초기화하는 역할)----------------
	public Member(int memberId, String memberName, String phone) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.phone = phone;
	}
	// ------------------------------------------

	// Getter, Setter ---------------------------
	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	// ----------------------------------------

}
