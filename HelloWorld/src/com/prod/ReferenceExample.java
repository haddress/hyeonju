package com.prod;

public class ReferenceExample {
	public static void main(String[] args) {
		
		// 참조타입 vs 기본(데이터)타입
		int num1 = 10; // 리터럴
		int num2 = 10; // 
		// int, double, (byte, short, long, float, char, boolean)
		
		
		System.out.println(num1);
		System.out.println(num2);
		
		String str1 = new String("hello");
		String str2 = new String("hello");
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str1 == str2); // str은 문자열이므로 연산자부호 이용 불가
		System.out.println(str1.equals(str2)); // 문자열일 경우에 비교하고 싶으면 equals라는 메소드를 이용하여 비교
		
	}

}
