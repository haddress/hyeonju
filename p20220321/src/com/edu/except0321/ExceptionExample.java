package com.edu.except0321;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionExample {
	public static void main(String[] args) {
		// 오류 : Error, Exception(웬만하면 정상적으로 작동하고 구문상의 오류(빨간줄)는 없으나 에러가 나는 예외. 실행시에 오류)
		// compile error, runtime error(실행을 해봐야 알 수 있는 에러)
		
		try {
		double result = 13 / 0;
		System.out.println("결과: " + result);
		} catch(ArithmeticException e) {
//			e.printStackTrace();
			System.out.println("0으로 나눌 수 없습니다.");
		}
		
		Scanner scn = new Scanner(System.in);
		System.out.println("숫자를 입력하세요.");
		try {
		int menu = scn.nextInt();
		} catch(InputMismatchException e) {
			System.out.println("숫자를 입력하시지 않았습니다.");
		}
		System.out.println("end of prog");
	}

}
