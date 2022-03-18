package com.edu;
// 객체지향프로그램언어
// 절차프로그램(데이터, 함수) -> 객체(데이터, 기능(함수), )
// Object(객체) -> Class(도면, 틀) -> 인스턴스 생성(도면을 바탕으로 실행.구현시킨 실체, 초기화, 인스턴스를 통해 값을 저장하고 호출)
// 학생(객체:Object) -> Class Student -> instance(new Student())

public class ObjectExample {
	public static void main(String[] args) {
		int num1 = 10;
		double num2 = 12.34;
		double num3 = 20; // int파일이지만 작은범위의 값(4바이트)을 큰범위에 값(8바이트)에 넣으면 내부에서 자동형변환이 되어 오류x
		int num4 = (int) 23.4; // 앞에 (int)를 설정하여 강제형변환을 하면 해당범위까지만 인식되어 사용가능. 실수부분 버림
		
		String str1 = "hello"; // str이라는 변수에 hello가 담기는 게 아니라 heap(인스턴스)생성되어 str1가 힙 영역에서. 주소값을 불러오는 것
		
		Car car1= new Car(); // car라는 값을 담기 위한 '인스턴스(초기화)'가 진행이 된 것
		
		// String도 원래 String str1 = new String();으로 인스턴스 해야하는데, string은 이미 자동으로 설정이 되어있음.
		
		car1.setModel("Sonata");
		car1.setPrice(10000000);
		
		Student s1 = new Student(); // 양쪽의 데이터타입이 같아야함. String s1 = new Student();는 성립안됨 | 초기화 시점에 값을 지정하고싶을때 생성자를 통해 값 지정 가능
		s1.setStudNo(100);
		s1.setStudName("김형민");
		s1.setKorScore(90);
		s1.setEngScore(80);
		s1.setMathScore(85);
		
		s1.setKorScore(95);
		
		System.out.println("영어점수 초기값: " + s1.getEngScore());
		System.out.println("이름의 초기값: " + s1.getStudName());
		
		System.out.println(s1.getStudName() + "의 합계: " + s1.getSumScore());
		System.out.println(s1.getStudName() + "의 평균: " + s1.getAvgScore());
		
		
	}

}
