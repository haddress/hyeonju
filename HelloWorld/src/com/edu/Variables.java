package com.edu;

public class Variables {
	public static void mai n(String[] args) {
		// 변수 : 메모리공간에 이름을 지정하고 이름에다 값을 할당하는 것 ex) age라는 이름에다 값 20을 저장
		int age = 20; // 20 == 30
		int num1 = 60;
		int num2 = 50;
		int result = num1 + num2;
		System.out.println(num1 + " + " + num2 + " = " + result);
		System.out.println("age변수: " + age);
		System.out.println("20 + 10 = 30");
		
		String name = "홍길동"; // 문자열
		name = "최민규"; // 또 String을 쓰게 되면 똑같은 선언문이 2개라 error
		System.out.println(name + "의 나이는 " + age + "입니다.");
		
		final String myName = "나현주"; // final => 상수(Constance). 항상 고정된 값
//		myName = "라현주";
		
		// 전화번호, 이메일 값을 담을 수 있는 변수 선언해보기
		
		String phone = "010-1234-5678";
		String email = "nhj@naver.com";
		System.out.println(myName + "의 전화번호는 " + phone + "이고, 이메일은 " + email + "입니다.");
		
	}
}
