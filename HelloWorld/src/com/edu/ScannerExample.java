package com.edu;

import java.util.Scanner; 

public class ScannerExample { // 원래 풀네임은 com.edu.ScannerExample
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in); // Scanner의 풀네임은 java.util.Scanner의 Scanner, 사용자가 입력한 것을 읽는 것
		
//		System.out.println("첫번째 숫자를 입력하세요..");
//		int val = scn.nextInt(); // nextInt는 사용자가 키보드로 입력값을 쳐야 진행됨
//		System.out.println("두번째 숫자를 입력하세요..");
//		int val2 = scn.nextInt();
//		int sum = val + val2;
		
		System.out.println("두 수의 합은 " + (10 + 20) + "입니다.");
		System.out.println("두 수의 합은 " + 10 + 20 + "입니다.");
		
		
//		if(val % 2 == 0) {
//			System.out.println("짝수입니다.");
//		}
//		if(val % 2 == 1) {
//			System.out.println("홀수입니다.");
//		}
		scn.close();
	}

}
