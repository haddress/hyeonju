package com.dev;

import java.util.Scanner;

public class IfExample3 {
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		System.out.println("1~3 사이의 임의의 숫자를 입력하시오.");
		int rotto = scn.nextInt();
		
		int ranVal = (int) (Math.random() * 3) + 1; // 0 ~ 1 사이의 임의의 값 실행 * 10 -> 0과 10 사이의 값이 실행될 것, 앞에 (int)를 붙이면 강제로 소숫점 이하 값 내림
		System.out.println(ranVal);
		
		if (rotto == ranVal) {
			System.out.println("정답입니다!");
		} else {
			System.out.println("틀렸습니다ㅠㅠ");
		}
		
		
		scn.close();
		
	}

}
