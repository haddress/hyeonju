package com.edu.api0322;

import java.lang.reflect.Method;

public class ClassExample {
	public static void main(String[] args) {
		// String, System, Member와 같은 클래스 정보를 관리해주는 클래스 = class(Class);

		Class cls = String.class;
		try {
			cls = Class.forName("java.lang.String");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(cls.getName());
		System.out.println(cls.getSimpleName());
		Method[] methods = cls.getMethods();
		for(Method met : methods) {
			System.out.println("메소드이름: " + met.getName());
		}
		
		
		cls = Member.class;
		
		String path = cls.getResource("ClassExample.class").getPath();
		System.out.println(path);

	}

}
