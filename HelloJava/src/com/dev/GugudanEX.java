package com.dev;

public class GugudanEX {

	// main메소드일 경우, static이 붙어있으면 인스턴스를 안 만들어도(초기화를 안 해도) 바로 실행됨.
	// 메소드 실행하려면 new 클래스이름(); 으로 작성했을때 메소드가 실행됨 ex) Student s1 = new Student();

//	Student.callStatic(); // 정적메소드가 실행됨. Student.java파일에 static을 만들어둠

	public static void main(String[] args) {
//		for (int i = 1; i <= 5; i++) {
//			printStar(i, "★"); // ○ ★
//			System.out.println();
//		}
//		gugudan(5);
		int result = sum(sum(10, 20), sum(5, 7));
		int[] newAry = { 10, 20, 30 };
		result = sum(newAry);
		System.out.println("결과는 " + result);
//		System.out.println(divide(10, 4));
	} // end of main()

	public static int sum(int[] ary) {
		// 배열매개변수의 각 요소의 합을 구하는 메소드
		int sum = 0;
		for (int i = 0; i < ary.length; i++) {
			sum += ary[i];
		}
		return sum;
	}

	// 나누기 메소드 ( int, int )
	// 반환되는 값은 double 타입으로
	// 0이 아닐때만 계산
	public static double divide(int n1, int n2) {
		if (n2 == 0) {
			return 0;
		}
		return n1 / n2;
	}

	public static int sum(int n1, int n2) {
		return n1 + n2;
	}

	public static void gugudan(int dan) {
		System.out.println("[ " + dan + "단]");
		for (int i = 1; i <= 9; i++) {
			System.out.printf("%2d * %2d = %2d\n", dan, i, (i * dan));
		}
		System.out.println();
	}

	public static void printStar(int runCnt, String shape) {
		for (int i = 0; i < runCnt; i++) {
			System.out.print(shape);
		}

	} // end of printStar

	public static void printGugudan() {

		for (int j = 2; j <= 9; j++) {
			int cnt = j;
			System.out.print("[" + cnt + "단]\t\t");
		}
		System.out.println();

		for (int j = 1; j <= 9; j++) {
			int cnt = j;
			for (int i = 2; i <= 9; i++) {
				System.out.print(i + " * " + cnt + " = " + (i * cnt) + "\t");
			}
			System.out.println();
		}
	} // end of printGugudan()

} // end of GugudanEx
