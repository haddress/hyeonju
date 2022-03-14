package com.edu;

import java.util.Scanner;

public class TemperatureExample {
	public static void main(String[] args) {
		// C = 5/9(F-23) 화씨온도를 섭씨온도로 변경하는 규칙
		Scanner scn = new Scanner(System.in);
//		double fDeg, cDeg;
		
		// 30.0 보다 크면 "오늘은 더운 날씨네요" 그 외는 "살만하네요"
		
		System.out.println("화씨온도 입력?");
		double fDeg = scn.nextDouble();
//		double fDeg2 = (double) 5/9*(fDeg-23);
		double cDeg = (double) 5 / 9 * (fDeg - 23);
//		boolean cDeg = fDeg2 > 30.0;
//		System.out.println(fDeg2);
		System.out.println(cDeg);
				
//			if(cDeg) {
//				System.out.println("오늘은 더운 날씨네요");
//			} else {
//				System.out.println("살만하네요");
//			}
			if (cDeg > 30.0) {
				System.out.println("오늘은 더운 날씨네요");
			} else {
				System.out.println("살만하네요");
			}
		
		
	}
	
}
