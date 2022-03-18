package com.dev;

public class Singleton {
	
	// 정적 필드
	private static Singleton instance = new Singleton();
	
	// 생성자
	private Singleton() {	
	}
	
	//정적 메소드
	public static Singleton getInstance() {
		return instance;
	}

}
