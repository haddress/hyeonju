package com.edu.except0322;

import java.util.Calendar;
import java.util.Scanner;

//class String2 extends String {
//	// public final String {} // 상속불가능한 클래스
//}


public class ExceptionExample2 {
	public static void main(String[] args) {

		// Object(제일 상위의 클래스)
		Object obj = new String();
		obj = new Scanner(System.in);
		obj = Calendar.getInstance();
		
		obj = new Object();
		System.out.println("obj의 해시코드: " + obj.hashCode());
		

		// 
		try {
			Class.forName("java.lang.String1");
		} catch (ClassNotFoundException/* 예외처리 */ el) {
//			el.printStackTrace();
			System.out.println("해당 클래스가 존재하지 않습니다.");
		}

		// RuntimeExeption
		String str = null;
		try {
			str.charAt(0); // CharSequence interface의 추상메소드
			System.out.println(str.toString());
		} catch (NullPointerException e) {
			System.out.println("널포인트 예외발생.");
			e.printStackTrace(); // 에러가 난 위치 표현
		}

		String nums1 = "100"; // 숫자문자열
		String nums2 = "200"; // 숫자문자열
		int num1, num2;
		try {
			num1 = Integer.parseInt(nums1); // int 변환
			num2 = Integer.parseInt(nums2);

			str.charAt(0);
		} catch (NumberFormatException e) {
			num1 = 0;
			num2 = 0;
		} catch (Exception e2) {
			num1 = 0;
			num2 = 0;

			System.out.println("상위의 예외발생 시..");
		}

		System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));

		try {
			showError();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("end of prog");

	} // end of main()

	public static void showError() throws ClassNotFoundException { // showError() 메소드를 호출하여 에러를 떠넘김. showError에서 예외처리를
																	// 해주어야함

		Class.forName("java.lang.Strings");
	}

} // end of class
