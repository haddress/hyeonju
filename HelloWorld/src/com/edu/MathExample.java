package com.edu;

import java.util.Scanner;

public class MathExample {
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		System.out.println("두 수를 입력하세요.");
		int num1 = scn.nextInt();
		int num2 = scn.nextInt();
		
		int plus = num1 + num2;
		int minus = num1 - num2;
		int multi = num1 * num2;
		int divi = num1 / num2;
		int remain = num1 % num2;
		
		System.out.println();
		System.out.println("두 수의 합: " + plus);
		System.out.println("두 수의 차: " + minus);
		System.out.println("두 수의 곱: " + multi);
		System.out.println("두 수의 몫: " + divi);
		System.out.println("두 수를 나눈 나머지: " + remain);
		
		scn.close();
	}

}
