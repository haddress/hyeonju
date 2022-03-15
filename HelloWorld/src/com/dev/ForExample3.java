package com.dev;

import java.util.Scanner;

public class ForExample3 {
	public static void main(String[] args) {
		// 입력받는 두 수를 num1, num2
		// num1과 num2 사이의 값 합 반복문
		
		Scanner scn = new Scanner(System.in);
		
		System.out.println("첫 번째 값을 입력하시오.");
		int num1 = scn.nextInt();
		System.out.println("두 번째 값을 입력하시오.");
		int num2 = scn.nextInt();
		
		int sum = 0; // 이 구문이 for문 밑에 있을 경우 계속 0으로 입력되어 누적되지 않고 갱신
		for(int i = num1; i <= num2; i++) {
			System.out.println(i);
			sum += i;
		}
		
		System.out.println(num1 + "부터 " + num2 + "까지의 합은 " + sum + "입니다.");
		
		scn.close();
		{
			int num3 = 0;
			System.out.println(num3);
		}
//		System.out.println(num3); // 블럭 밖에 있으므로 num3 출력 불가능
		{
			int num3 = 10;
		}
		
		

	}

}
