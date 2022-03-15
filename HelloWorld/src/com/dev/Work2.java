package com.dev;

import java.util.Scanner;

public class Work2 {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int num1, num2, num3;
		System.out.println("첫 번째 수를 입력하시오.");
		num1 = scn.nextInt();
		System.out.println("두 번쨰 수를 입력하시오.");
		num2 = scn.nextInt();
		System.out.println("세 번째 수를 입력하시오.");
		num3 = scn.nextInt();

		if (num1 > num2 && num2 > num3) {
			System.out.println(num1 + ", " + num2 + ", " + num3);
		} else if (num1 > num3 && num3 > num2) {
			System.out.println(num1 + ", " + num3 + ", " + num2);
		} else if (num2 > num1 && num1 > num3) {
			System.out.println(num2 + ", " + num1 + ", " + num3);
		} else if (num2 > num3 && num3 > num1) {
			System.out.println(num2 + ", " + num3 + ", " + num1);
		} else if (num3 > num1 && num1 > num2) {
			System.out.println(num3 + ", " + num1 + ", " + num2);
		} else if (num3 > num2 && num2 > num1) {
			System.out.println(num3 + ", " + num2 + ", " + num1);
		}

	}

}
