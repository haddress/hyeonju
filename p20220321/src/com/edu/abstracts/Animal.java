package com.edu.abstracts;

public abstract class Animal {
	
	private String name;
	
	public Animal() {
		System.out.println("Animal() 생성자 호출.");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	// 추상메소드 정의 -> animal클래스를 상속받는 클래스는 강제로 이 기능들이 구현되도록
	public abstract void eat(); // 구현({})되는 부분이 없음. 선언하는 부분만 존재한다.
	public abstract void speak();
	
}
