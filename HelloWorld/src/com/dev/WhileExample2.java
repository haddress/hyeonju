package com.dev;

public class WhileExample2 {
	public static void main(String[] args) {
		// for문을 while문으로 바꾸기 -> 1~10까지의 수 중에서 짝수만 출력
		
		int i = 1;
		System.out.print("짝수:");
		while(i <= 10) {
			if(i % 2 == 0) {
				System.out.print(i + " ");
			}
			i++;
		}
	}

}
