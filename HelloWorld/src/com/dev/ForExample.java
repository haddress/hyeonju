package com.dev;

public class ForExample {
	public static void main(String[] args) {
		
//		i = i + 1;
//		i += 1;
//		i++;
		
//		1 ~ 10까지 다 더하면 얼마?
		int sum = 0;
		for(int i = 1; i <= 5; i++) { // int는 대부분 i로 사용. 처음에 1값, 실행했을 때 10보다 작거나같음을 만족하면 println 실행, 그 다음에는 증가(+) 또는 감소(-)를 통해 i의 값 변경
			System.out.println(i);
			sum = sum + i;
		}
		System.out.println("합계: " + sum);
		
//		System.out.println("1");
//		System.out.println("2");
//		System.out.println("3");
//		System.out.println("4");
//		System.out.println("5");
//		System.out.println("6");
//		System.out.println("7");
//		System.out.println("8");
//		System.out.println("9");
//		System.out.println("10"); // for문을 사용하지 않을 경우, 계속해서 출력을 실행해야함
	}

}
