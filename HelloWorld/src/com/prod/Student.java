package com.prod;

public class Student {
	// 22-123456
	// 필드 : 정보 저장. 
	String studentNo;
	String studentName;
	int korScore;
	int engScore;
	
	// method : 기능구현이 가능. 함수
	void study(String subject) {
		System.out.println(subject + "를(을) 공부합니다.");
	}
	
	void eat(String food) { // eat는 매개변수
		System.out.println(food + "을 먹습니다.");
	}
	
	int getKorScore( ) {
		return korScore;
	}
	
	int getEngScore() {
		return engScore;
	}
	
	

}
