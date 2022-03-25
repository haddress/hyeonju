package com.edu.thread0325;

// 클래스 병렬처리 예시(쓰레드 클래스 상속받아서 만드는 방법)

import java.awt.Toolkit;

class BeepThread extends Thread {

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

public class BeepPrintExample2 {
	public static void main(String[] args) { // main메소드를 멀티쓰레드로 실행
		// 1. 비프음 생성
		// Thread클래스를 상속받는 클래스를 선언, run메소드를 override하는 기능을 구현
		Thread thread = new BeepThread();
		thread.start();

		// 2. 비프 문장 출력
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
