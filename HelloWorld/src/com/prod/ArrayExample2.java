package com.prod;

public class ArrayExample2 {
	public static void main(String[] args) {

		// 정수를 담을 수 있는 배열
		// ages 선언 -> int, 공간 3개 담을 수 있도록

		int[] ages = new int[3];

		ages[0] = 20;
		ages[1] = 23;
		ages[2] = 27;

		for (int i = 0; i < 3; i++) {
			System.out.println("저는 " + ages[i] + "살 입니다.");
		}

		// sumAge, avgAge
		
		ages[0] = 30;
		ages[1] = 32;
		ages[2] = 35;

		int sumAge = 0;
		for (int i = 0; i < 3; i++) {
			sumAge += ages[i];
		}
		double avgAge = sumAge / (double) 3;
		System.out.printf("%.2f \n", avgAge); // ?
		System.out.println("평균 나이는 " + avgAge + "입니다.");
		

	}

}
