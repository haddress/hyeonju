package com.dev;

import java.util.Scanner;

public class WhileExample3 {
	public static void main(String[] args) {
		// 입력을 계속 입력할 수 있도록
		// -1 값을 입력하면 입력을 멈추겠다는 뜻
		// sum 값에 입력
		
		// 스캐너 선언. sum(0으로 초기화) 정수 선언
		// while 조건 true
		// 숫자를 입력하세요.
		// inputVal 이라고 변수 달아주기
		// 입력값이 -1이면 반복문 종료
		// 합계는 sum
		
		
		Scanner scn = new Scanner(System.in);
		
		int sum = 0;
		while(true) {
			System.out.println("숫자를 입력하세요.");
			int inputVal = scn.nextInt();
				if(inputVal == -1) {
					break;
				} else {
					sum+=inputVal;
				}
		}
		System.out.println("합계는 " + sum + "입니다.");
		
		
	}

}
