package com.edu;

public class SwimMember extends Member {
	// 강습반의 강사이름.
	// 수영등급(A,B,C,D)

	private String teachName;
	private String swimGrade;

	public SwimMember() {

	}

	public SwimMember(int memberId, String memberName, String phone, String teachName, String swimGrade) {
		super(memberId, memberName, phone);
		this.teachName = teachName;
		this.swimGrade = swimGrade;
	}

	public String getTeachName() {
		return teachName;
	}

	public void setTeachName(String teachName) {
		this.teachName = teachName;
	}

	public String getSwimGrade() {
		return swimGrade;
	}

	public void setSwimGrade(String swimGrade) {
		this.swimGrade = swimGrade;
	}

	// 정보출력시 => 강사이름: 홍길동, 등급: A
	@Override
	public String toString() {
		String str = "회원 아이디: " + super.getMemberId() + "\n";
		str += "회원 이름: " + super.getMemberName() + "\n";
		str += "회원 휴대폰 번호: " + super.getPhone() + "\n";
		str += "강사 이름: " + this.getTeachName() + "\n";
		str += "수영 등급: " + this.getSwimGrade() + "\n";
		return str;
	}

}
