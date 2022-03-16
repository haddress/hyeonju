package com.prod;

public class ArrayExample4 {
	public static void main(String[] args) {

		int[] numbers = { 35, 22, 17, 40, 28, 33, 36 };

		int sum = 0;
		int cnt = 0; // if 조건이 몇 번 실행됐는지 카운트하는 용도로 사용
		for(int i = 0; i < numbers.length;i++) { // numbers.length로 설정해놓으면 값이 추가되어도 숫자를 변경할 필요없음
			if(numbers[i] % 2 == 0) {
				sum += numbers[i];
				cnt++;
				
			}
		}
		System.out.println("짝수값의 합: " + sum);
		System.out.println("짝수값의 평균: " + (sum / (double) cnt));
	}

}
