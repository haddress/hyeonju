package com.edu0321;

public class Friend extends Person {
	// 출신지역 : 이름, 나이, 키, 몸무게 -> 회사친구(회사이름, 회사업무) / 학교친구(학교이름, 전공)
	private String phone;
	
	public Friend() {
		super();
	}
	
	// public Friend() {} => super();
	public Friend(String name, int age, double height, double weight, String phone) {
		super(name, age, height, weight);
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	
	// overriding => 부모클래스의 메소드를 자식클래스의 필요에 맞게 새롭게 정의하는 것
	@Override // 부모클래스 메소드 재정의. 규칙 지정하겠다는 뜻. annotation
	public String toString() {
		String str = "친구의 이름은 " + super.getName() + "이고 \n";
		str += "나이는 " + super.getAge() + "이고 \n";
		str += "연락처는 " + this.getPhone() + "입니다. \n";
		return str;
	}	
	
}
