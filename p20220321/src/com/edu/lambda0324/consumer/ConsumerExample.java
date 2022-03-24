package com.edu.lambda0324.consumer;

import java.util.function.*; // java.util.function 밑에 있는 요소들을 다 import하겠다

public class ConsumerExample {
	public static void main(String[] args) {

		// functional interface = 람다표현식 가능(반환값없이 단순히 내부적으로 처리가 끝날때 가능)
		// 구현하고싶은 인터페이스 accept 하나 => 함수식 인터페이스
		Consumer/* 인터페이스 */<String> consumer/* 인터페이스 구현하는 객체 */ = (t) -> {
			System.out.println(t + "출력합니다.");
		};
		consumer.accept("메세지를 ");

		BiConsumer<Integer, Integer> biCon = (t, u) -> {

			System.out.println("result =>" + (t + u));
		};
		biCon.accept(20, 40);
	}
}
