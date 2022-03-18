package com.dev;

public class SingletonExample {
	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance(); // new Singleton();
		Singleton s2 = Singleton.getInstance(); // new Singleton();
		// 하나의 객체만 리턴하므로 s1, s2 둘 다 동일한 객체를 참조
		
		// singleton : instance를 여러개 만들었어도 한 번 만들어진 걸로 공용으로 사용
		
		System.out.println(s1);
		System.out.println(s2);
		
	}

}
