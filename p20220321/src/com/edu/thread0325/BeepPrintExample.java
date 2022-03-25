package com.edu.thread0325;

// 멀티쓰레드 첫번째 방법(Runnable 인터페이스를 구현해서 만든 방법)

import java.awt.Toolkit;

class BeepTask implements Runnable {

	@Override
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for (int i = 0; i < 5; i++) {
			toolkit.beep();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

// process(main쓰레드). 지금까지는 싱글스레드를 사용->동시에 두 개의 작업이 불가
public class BeepPrintExample {
	public static void main(String[] args) {

		// 쓰레드 생성하는 방법
		// Thread class의 생성자의 매개값으로 Runnable 인터페이스를 구현한 객체
//		Thread thread = new Thread(new BeepTask()/*아무것도없는 기본 생성자*/);
		
		// Runnable이라는 인터페이스의 익명구현개체를 생성하여 Thread라고 하는 클래스의 생성자 매개값으로 활용
		Thread thread = new Thread/*쓰레드를 새로 만들겠다. 뒤의 중괄호와 같은 기능을 가진*/(() -> {
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			for (int i = 0; i < 5; i++) {
				toolkit.beep();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}); // 만든 쓰레드 기능 끝

		thread.start(); // 쓰레드 시작

		for (int i = 0; i < 5; i++) {
			System.out.println("beep");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("end of prog");

	}
}
