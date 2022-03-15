package com.dev;

import java.util.Scanner;

public class ForExample4 {
	public static void main(String[] args) {
		// 1~10 까지 수중에서 짝수의 값 => evenSum, 홀수의 값 => oddSum
		// 짝수의 값의 합, 홀수의 값의 합

		int num = 48; // 약수의 모든 숫자를 구하는 프로그램
		for (int i = 1; i <= num; i++) {
			if (num % i == 0) {
				System.out.print(i + " ");
			}
		}

		System.out.println();
		System.out.println();

		int sum1 = 0;
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 0) {
				sum1 += i;
			}
		}
		System.out.println("짝수의 합: " + sum1);

		int sum2 = 0;
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 1) {
				sum2 += i;
			}
		}
		System.out.println("홀수의 합: " + sum2);

		System.out.println();

		Scanner scn = new Scanner(System.in);
		int num1, num2, var = 0;
		System.out.println("첫 번째 수를 입력하시오.");
		num1 = scn.nextInt();
		System.out.println("첫 번째 수 보다 큰 두 번째 수를 입력하시오.");
		num2 = scn.nextInt();

		for (int i = 1; i <= num2; i++)
			if (num1 % i == 0 && num2 % i == 0) { // 두 값을 동시에 구하기 위해 && 사용하기
				var = i; // 변수 var를 설정하여, 반복문을 계속 실행 한 후 마지막에 나올 숫자를 var로 지정하기
			}
		System.out.println(num1 + "와 " + num2 + "의 최대공약수는 " + var + "이다.");

		scn.close();

	}

}
