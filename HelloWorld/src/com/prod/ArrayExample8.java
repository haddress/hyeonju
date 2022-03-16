package com.prod;

import java.util.Scanner;

public class ArrayExample8 {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		int[] numbers = new int[2];
		
		System.out.println("첫 번째 값을 입력하시오.");
		numbers[0] = scn.nextInt();
		
		System.out.println("두 번째 값을 입력하시오.");
		numbers[1] = scn.nextInt();
		
		if(numbers[0] > numbers[1]) {
			int temp = numbers[0];
			numbers[0] = numbers[1];
			numbers[1] = temp;
		}
		
		System.out.println("첫번째값: " + numbers[0]);
		System.out.println("첫번째값: " + numbers[1]);
		
//		if(numbers[0] < numbers[1]) {
//			System.out.println("첫번째값: " + numbers[0]);
//			System.out.println("첫번째값: " + numbers[1]);
//		} else {
//			System.out.println("첫번째값: " + numbers[1]);
//			System.out.println("첫번째값: " + numbers[0]);
//		}
		
		
		
		
		
	}

}
