package com.test;

import java.util.Scanner;

//문제3) 정수형배열 선언하고 사용자로 세개의 정수값을 입력받아서 배열에 저장. 제일 큰값을 구하는 코드를 작성.
public class Exam03 {
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		System.out.println("첫 번째 정수값을 입력하시오.");
		int n1 = scn.nextInt();
		System.out.println("두 번째 정수값을 입력하시오.");
		int n2 = scn.nextInt();
		System.out.println("세 번째 정수값을 입력하시오.");
		int n3 = scn.nextInt();

		System.out.println("n1: " + n1);
		System.out.println("n2: " + n2);
		System.out.println("n3: " + n3);

		int[] num = { n1, n2, n3 };

		int max = num[0];

		for (int i = 1; i < num.length; i++) {
			if (num[i] > max) {
				max = num[i];
			}
			
			System.out.println("가장 큰 값: " + max);

		}

	}
}
