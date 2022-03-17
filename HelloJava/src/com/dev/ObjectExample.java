package com.dev;

import java.util.Scanner;

import com.edu.Student;

public class ObjectExample {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		Student s1 = new Student(100, "이가영"); // studNo = 100 | 다른 패키지에서 int타입의 매개변수 지정해주었으므로 오류x
		System.out.println(s1.getStudNo());
		System.out.println(s1.getStudName());
		s1.setKorScore(100);
		s1.setEngScore(60);
		s1.setMathScore(80);

		Student s2 = new Student(101, "이혜린", 80, 82, 85); // 생성자를 통해서 필드의 값을 지정 가능
		System.out.printf(s2.getStudName() + "의 평균: %.2f", s2.getAvgScore());

		Student s3 = new Student(102, "서현일", 70, 80, 90);
		Student s4 = new Student(103, "최규완", 77, 82, 83);

		Student[] students = { s1, s2, s3, s4 };
		while (true) {
			System.out.println("\n조회하려는 학생의 이름: ");
			String searchName = scn.next();
			if (searchName.equals("종료")) {
				break;
			}

			for (int i = 0; i < students.length; i++) {
				if (students[i].getStudName().equals(searchName)) {
					System.out.println(students[i].getStudInfo());
				}
			}

		}

		System.out.println("end");

//		==================================================================		

//		s1.setStudNo(100); // com.edu 패키지에서 void로 설정되어있으므로 현재 패키지에서 호출 불가
//		s1.setStudName("이가영"); // com.edu 패키지에서 public으로 설정되어있으므로 현재 패키지에서 호풀 가능
//		
		// private, void, public 셋 중 하나로 설정하기. 패키지가 같거나 다르거나 상관없이 사용할 경우 public
		// void는 같은 패키지에서 가능, private는 같은 클래스에서만 가능

	}

}
