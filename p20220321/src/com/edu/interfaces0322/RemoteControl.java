package com.edu.interfaces0322;

public interface RemoteControl {
	
	// 필드 불가
//	public String maxVolume;
	public static final int MAX_VOLUME = 10; // 상수로 선언 가능
	public static final int MIN_VOLUME = 0; // 상수로 선언 가능
	
	// 생성자 불가
	
	// 메소드만 가능
	public void powerOn(); // 추상메소드
	public void powerOff();
	

}
