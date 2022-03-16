package com.prod;

public class MemberExample {

	public static void main(String[] args) {
		// int num1=10;
		// String name = "홍길동";
		// ?? member = "홍길동", 10;
		
		Member mem1 = new Member(); // name, age는 속성 x, 단순히 실제 메모리 공간에 값을 담기 위해 변수를 초기화 한 것뿐
		mem1.name = "홍길동";
		mem1.age = 20;
		
		Member mem2 = new Member(); // new Member()를 통해 변수 초기화
		mem2.name = "김민수";
		mem2.age = 25;
		
		System.out.println("mem1의 name속성: " + mem1.name);
		System.out.println("mem1의 age속성: " + mem1.age);
		
		Student st1 = new Student(); // Student() 초기화
		st1.studentNo = "22-123456";
		st1.studentName = "김영희";
		st1.korScore = 90;
		st1.engScore = 80;
		
		Student st2 = new Student();
		
	}

}
