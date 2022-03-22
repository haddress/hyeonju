package com.edu.nested0322;

public class Outer {
	private String field1;
	private int field2;
	
	class Inner { // 멤버 클래스 : 클래스 안에 생성되어 있는 필드, 메소드 등이 멤버에 해당
		String field3;
		int field4;
		
		void method2() {
			System.out.println("Inner.method2()");
		}
	}
	
	// --------------------------------------------------------
	
	// 함수적 인터페이스 : 구현해야 할 메소드가 하나인 것
	interface Runnable {
		void run(); // run이라고하는 추상메소드 o
	}
	
	
	class Bus implements Runnable {

		@Override
		public void run() {
			System.out.println("Runnable.run()");
		}
		
	}
	
	public String getField1() {
		return field1;
	}
	
	public void method1() {
		System.out.println("Outer.method1()");
		Inner inner = new Inner();
		inner.method2();
	}
	
	public void method3() {
		System.out.println("Outer.method3()");
		
		class Local { // 메소드 안에 선언된 클래스 -> 로컬클래스
			
			void method4() {
				System.out.println("Local.method4()");
			}
		}
		Local local = new Local();
		local.method4();

	}
	
	public void method4() {
		Runnable runnable = new Bus(); // 인터페이스의 구현객체 가능
		runnable.run();
		
		
		runnable = () -> System.out.println("임의의 객체를 실행합니다."); // 람다식, 인터페이스 안에 메소드가 하나일 때 람다식 사용 가능
		
		// 익명구현객체 -> 1회용, 메소드 안에서만 사용 가능
		// Lambda 표현식.
//		runnable = new Runnable() { //Runnable을 구현하는 익명구현객체, 그때그때 필요한 객체구현해서 굳이 클래스 만들 필요 없을때
			
//			@Override
//			public void run() { // run이라는 추상메소드 재정의하는 과정 필요
//				System.out.println("임의의 객체를 실행합니다.");
				
//			}
//		};
		
		runnable.run();
		
		
	}

}
