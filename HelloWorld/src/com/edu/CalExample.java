package com.edu;

import java.util.Scanner;

public class CalExample {
	public static void main(String[] args) {
		// 초(ex. 100초) 입력 -> 시/분/초 로 변경하기
		Scanner scn = new Scanner(System.in);
	
		System.out.println("초 단위 입력(ex: 150): ");
		int inputVal = scn.nextInt();
		int hour = inputVal / 3600; // 5000/3600 => 1시간
		int minute = inputVal % 3600 / 60; // 5000%3600 => 1400/60 => 23분
		int second = inputVal % 60; // 5000%60 => 20초
		
		System.out.println(hour + "시간 " + minute + "분 " + second + "초");
		
		
		scn.close();
	}

}