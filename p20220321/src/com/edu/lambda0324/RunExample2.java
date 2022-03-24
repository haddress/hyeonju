package com.edu.lambda0324;

// 매개변수가 있고 반환값이 없는 익명 클래스

interface Runnable2 {
	public void run(String animal); // 구현해야 할 메소드 run 하나뿐
}

public class RunExample2 {
	public static void main(String[] args) {
		Runnable2 runnable = (String animal/* 인터페이스에 매개값이 있어서 여기도 생성 */) -> {
			System.out.println(animal + "이(가) 달립니다.");

		}; // (String animal)이라는 매개값을 받아서 블럭{}을 호출
		runnable.run("호랑이");
	}

}
