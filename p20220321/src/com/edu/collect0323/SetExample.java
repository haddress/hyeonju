package com.edu.collect0323;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetExample {
	public static void main(String[] args) {
		
		Set<String> set = new HashSet<String>(); // set: 중복값을 허용하지 않는 특징을 가짐
		set.add("Hello");
		set.add("World");
		set.add("Good");
		set.add("World"); // 중복값 허용하지않으므로 추가되지 않음
		
		set.remove("Good");
		
		System.out.println("set 크기: " + set.size());
		
		Iterator<String> iter = set.iterator(); // iterator: 반복자?
		while(iter.hasNext()) {
			String result = iter.next();
			System.out.println(result);
		
		}
		System.out.println("end of prog");
	}
}
