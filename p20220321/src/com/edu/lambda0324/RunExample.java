package com.edu.lambda0324;

// 매개변수가 없고 반환값도 없는 익명 클래스 생성

interface Runnable {
	public void run();
}

class RunImpl implements Runnable {

	@Override
	public void run() {
		System.out.println("run...");
	}

}

public class RunExample {
	public static void main(String[] args) {
		// 람다표현식 (String s) -> { 구현코드 };

		Runnable runnable = new RunImpl(); // runnable이라는 변수에 클래스 생성
		runnable.run();

		runnable = new Runnable() { // Runnable 인터페이스를 구현해주기위한 익명객체를 클래스 없이 바로 선언

			@Override
			public void run() {
				System.out.println("호랑이가 달립니다.");
			}

		}; // 익명구현객체
		runnable.run();

		runnable = () -> {
			System.out.println("사자가 달립니다.");
		};

		// runnable이라는 변수는 Runnable이라는 인터페이스의 변수. 따라서 new Runnable()을 지워도 알 수 있음(?)
		// ()에 있는 변수를 받아서 -> {} 에서 실행시킬것.

		runnable.run();

	}

}
