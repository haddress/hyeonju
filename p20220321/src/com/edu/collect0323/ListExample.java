package com.edu.collect0323;

import java.util.ArrayList;

public class ListExample {
	public static void main(String[] args) {
		String[] strings = new String[10];
		for(int i=0; i<strings.length; i++) {
			if(strings[i]==null) {
				strings[i] = "hello";
				break;
			}
		}
		
		ArrayList<String> strAry = new ArrayList<String>(); // <>:제너릭
		strAry.add("hello");
		strAry.add("world");
		
		strAry.get(1);
		strAry.set(1, "월드"); // 인덱스 1의 위치값을 지정한 뒤, world를 월드로 수정
		strAry.remove(1); // 인덱스 1의 값을 삭제
		strAry.clear(); // 전부 다 지우기
		System.out.println("strAry.size() => " + strAry.size());
		
		for(int i = 0; i < strAry.size(); i++) {
			String result = strAry.get(i);
			System.out.println(result);
		}
		
		
		
//		ArrayList<Integer> numAry = new ArrayList<Integer>();
//		for(int i = 0; i < numAry.size(); i++) {
//			Integer result = numAry.get(i);
//		}
		
	}
}
