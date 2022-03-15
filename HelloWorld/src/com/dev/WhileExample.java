package com.dev;

import java.util.Scanner;

public class WhileExample {
	public static void main(String[] args) {
		// for
		for(int i = 1; i <= 5; i++) {
			System.out.println("1의 값=> " + i);
		}
		System.out.println();
		
		// while
		int i = 1; // i값 초기화
		while(i <= 5) { // 조건식 입력
			i++; // 증감식 입력
			System.out.println("1의 값=> " + i);
			
		}
		System.out.println();
		
		// while
		int num = 0;
		while(true) { // while(true) -> 무한반복
			System.out.println("num의 값=> " + num);
			num++;
			if(num > 5) {
				break; // 반복문을 빠져나옴, switch, for, while 등에 사용
			}
		}
		System.out.println();
		
		// while
		while(true) {
			int rand = (int) (Math.random()* 10) + 1; // 1~10사이의 랜덤숫자에 1 더해서 정수
			System.out.println("임의의 생성된 값: " + rand);
			if(rand == 8) {
				break; // rand가 8이 되면 break빠져나옴
			}
		}
		System.out.println();
		
		// 숫자를 맞출 때까지 계속 반복
		int randomVal, userVal;
		Scanner scn = new Scanner(System.in);
		while(true) {
			randomVal = (int) (Math.random()* 5) + 1; // 1~5사이의 랜덤숫자에 1 더해서 정수
			System.out.println("1~5 사이의 임의의 값을 입력하세요.");
			userVal = scn.nextInt();
			
			if (randomVal == userVal) {
				System.out.println("생성된 임의의 값과 입력한 값이 일치합니다.");
				break;
			}
			
		}
		
		System.out.println("end of prog");
	}

}
