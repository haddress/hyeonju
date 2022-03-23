package com.edu.generic0323;

import java.util.ArrayList;

public class BoxExample {
	public static void main(String[] args) {
//		Box box = new Box();
//		box.setObj("Hello"); // 필드 obj
//		String result = (String) box.getObj(); // 담겨져있는 obj가 String타입이 담겨져있음
//		System.out.println(result);
//		
//		Integer result1 = (Integer) box.getObj(); // String타입이 담겨져있으니 int로 불러올 수 x. 따라서 
//		System.out.println(result1);
		
		Box<String> stringBox = new Box<String>();
		stringBox.setObj("Hello");
		String result = stringBox.getObj();
		
		Box<Integer> intBox = new Box<Integer>();
		intBox.setObj(100);
		Integer result1 = intBox.getObj();
		
		ArrayList<Integer> intAry = new ArrayList<Integer>();
		
		
	}
}
