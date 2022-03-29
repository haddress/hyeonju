package com.edu;

public class SoccerMember extends Member {

	// 축구반의 코치이름.
	// 락커룸의 이름.(A, B, C, D)

	private String coach;
	private String locker;

	public SoccerMember() {

	}

	public SoccerMember(int memberId, String memberName, String phone, String coach, String locker) {
		super(memberId, memberName, phone);
		this.coach = coach;
		this.locker = locker;
	}

	public String getCoach() {
		return coach;
	}

	public void setCoach(String coach) {
		this.coach = coach;
	}

	public String getLocker() {
		return locker;
	}

	public void setLocker(String locker) {
		this.locker = locker;
	}

	// 정보출력시 => 코치이름: 홍길동, 락커룸: A
	@Override
	public String toString() {
		String str = "회원 아이디: " + super.getMemberId() + "\n";
		str += "회원 이름: " + super.getMemberName() + "\n";
		str += "회원 휴대폰 번호: " + super.getPhone() + "\n";
		str += "코치 이름: " + this.getCoach() + "\n";
		str += "락커룸 번호: " + this.getLocker() + "\n";
		return str;
	}

}
