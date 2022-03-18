package com.test;

import java.util.Scanner;

//문제2) 정수형 변수 n1, n2를 선언하고 Scanner 클래스를 통하여 두정수를 입력받은 후 큰수에서 작은 수를 나눈 결과값을 소수점 첫번째까지 구하는 기능 작성. 
public class Exam02 {
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		System.out.println("정수형 변수 n1를 입력하시오.");
		int n1 = scn.nextInt();
		System.out.println("정수형 변수 n2를 입력하시오.");
		int n2 = scn.nextInt();

		if (n1 > n2) {
			System.out.println(String.format("%.1f", ((double) n1 / (double) n2)));
		} else {
			System.out.println(String.format("%.1f", ((double) n2 / (double) n1)));
		}

	}
}
