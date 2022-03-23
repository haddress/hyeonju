package com.edu.collect0323;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentApp {
	// 배열은 크기를 한 번 정하면 변경하기가 어렵기때문에 컬렉션을 사용
	// 배열에서는 class만 사용하여 데이터타입을 정리, 컬렉션에서는 인터페이스와 nested class까지 기능 확장해서 사용 가능

	List<Student> list = new ArrayList<Student>();
	Scanner scn = new Scanner(System.in);

	// 내부클래스(멤버클래스)
	class StudentServiceImpl implements StudentService { // 규칙이 지정된 미완성인 인터페이스를 실체로 구현하기 위해 ..impl 사용

		@Override
		public void insertStudent(Student student) {
			list.add(student); // 추가

		}

		@Override
		public Student getStudent(int sno) { // 학생번호로 한 건만 조회
			for (int i = 0; i < list.size(); i++) { // list에 담겨있는 건 개수(?)
				if (list.get(i)/* list클래스에 있는 건을 갖고(get)오겠다 */.getStuNum() == sno) {
					return list.get(i); // 같은 번호가 있으면 student 클래스 리턴
				}
			}
			return null;
		}

		@Override
		public List<Student> studentList() { // 전체 학생 정보를 가져오겠다. 전체 리스트
			return null;
		}

		@Override
		public void modifyStudent(Student student) { // 학생번호가 key의 역할. 학생번호를 기준으로 똑같은 번호를 찾아서 그 학생의 정보를 Student student
														// 값으로 변경.수정하겠다
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getStuNum() == student.getStuNum()) {
					list.get(i)/* 리스트에 있는 학생의 */.setEngScore(
							student.getEngScore()/* modifyStudent에 있는 student로 점수를 바꿔주겠다 */);
					list.get(i).setKorScore(student.getKorScore());
				}

			}

		}

	} // StudentServiceImpl 클래스 끝

	public void execute() {
		// 메뉴 : 1.추가 2.리스트 3.한건조회 4.수정 9.종료
		while (true) {
			System.out.println("1.추가 2.리스트 3.한건조회 4.수정 9.종료");
			System.out.print("선택>> ");

			// 메뉴입력
			int menu = scn.nextInt();
			if (menu == 1) {

			} else if (menu == 2) {

			} else if (menu == 3) {

			} else if (menu == 4) {

			} else if (menu == 9) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		} // while 끝
		System.out.println("끝");

	}

}
