package com.prod;

public class StudentExample {
	public static void main(String[] args) {
		Student s1 = new Student();
		s1.studentName = "홍길동";
		s1.korScore = 80;
		
		s1.study("영어"); // s1이라는 변수는 study라는 기능도 가짐
		s1.eat("급식");
		s1.eat("간식");
		s1.eat("초콜릿");
		
		int v1 = s1.getKorScore();
		int v2 = s1.getEngScore();		
		System.out.println("국어점수: " + v1 + ", 영어점수: " + v2);
		
		
		
	}

}
