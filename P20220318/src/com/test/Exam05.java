package com.test;

import java.util.Scanner;

// 문제5) Book클래스를 선언(필드:책제목, 저자, 출판사, 금액) 
//      생성자(책제목, 저자, 출판사, 금액)를 선언 후 Scanner클래스를 사용하여 사용자의 입력을 통하여 인스턴스를 생성하고 
//      입력한 내용을 책제목, 저자, 출판사, 금액 정보를 화면에 출력하는 기능 구현.
public class Exam05 {
	public static void main(String[] args) {

		
		Book[] books;
		
		Scanner scn = new Scanner(System.in);


		System.out.print("책 제목>> ");
		String title = scn.next();
		
		System.out.print("책의 저자>> ");
		String writer = scn.next();
		
		System.out.print("출판사>> ");
		String company = scn.next();
		
		System.out.println("가격>> ");
		int price = scn.nextInt();
		

		
		
		
		
		

	}
}
