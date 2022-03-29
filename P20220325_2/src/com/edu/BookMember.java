package com.edu;

public class BookMember extends Member {
	// 도서반의 반장이름.
	// 도서반의 강의실정보.(지혜실, 지식실, 모험실)

	private String leader;
	private String classRoom;

	public BookMember() {

	}

	public BookMember(int memberId, String memberName, String phone, String leader, String classRoom) {
		super(memberId, memberName, phone);
		this.leader = leader;
		this.classRoom = classRoom;
	}

	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	public String getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(String classRoom) {
		this.classRoom = classRoom;
	}

	// 정보출력시 => 반장이름: 홍길동, 강의실: 모험실
	@Override
	public String toString() {
		// String info = super.toString(); // 부모클래스(Member)의 id, name, phone을 info로 출력
		// info += "도서반장 이름: " + leader + "\n";
		// info += "강의실 정보: " + classRoom + "\n";
		String str = "회원 아이디: " + super.getMemberId() + "\n";
		str += "회원 이름: " + super.getMemberName() + "\n";
		str += "회원 휴대폰 번호: " + super.getPhone() + "\n";
		str += "도서반장 이름: " + this.getLeader() + "\n";
		str += "강의실 정보: " + this.getClassRoom() + "\n";
		return str;
	}
}
