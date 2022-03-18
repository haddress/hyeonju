package com.test;

//문제4) 1 ~ 6까지 임의의 정수를 생성하는 Math.random()을 사용하여 작성하세요.
//생성된 값을 정수배열(크기 5)를 선언 후 값을 저장 후 가장 큰 값을 구하는 코드를 작성.
public class Exam04 {
	public static void main(String[] args) {

		int[] num = new int[5];
		int max = num[0];

		for (int i = 0; i < num.length; i++) {
			num[i] = ((int) ((Math.random()) * 6) + 1);
			System.out.print(num[i] + "\t");
			if (num[i] > max) {
				max = num[i];
			}
		}
		System.out.println();
		System.out.println("가장 큰 값: " + max);
	}
}