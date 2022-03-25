package com.edu.collect0323;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentApp {
	// 배열은 크기를 한 번 정하면 변경하기가 어렵기때문에 컬렉션을 사용
	// 배열에서는 class만 사용하여 데이터타입을 정리, 컬렉션에서는 인터페이스와 nested class까지 기능 확장해서 사용 가능

	List<Student> list = new ArrayList<Student>(); // list라는 필드는 StudentApp 클래스가 아닌 곳에서는 공유 불가하므로 아래에 생성한
													// StudentService라는 인터페이스를 통해 읽어올 수 있도록
	Scanner scn = new Scanner(System.in);

	// 생성자
	public StudentApp() {
//		list.add(new Student(101, "권가희", 50, 60)); // 리스트 컬렉션에 값을 담음
//		list.add(new Student(102, "유해정", 70, 80));
//		list.add(new Student(103, "이유빈", 90, 70));
//		list.add(new Student(104, "권가희", 100, 100));
	}

	// 내부클래스(멤버클래스)
	class StudentServiceFile implements StudentService { // 규칙이 지정된 미완성인 인터페이스를 실체로 구현하기 위해 ..impl 사용

		@Override
		public void insertStudent(Student student) {
			list.add(student); // 추가, 리스트 컬렉션에 student값을 받아서 추가

		}

		@Override
		public void saveToFile() {
			try {
				FileWriter fw = new FileWriter("studentList.data");
				BufferedWriter bw = new BufferedWriter(fw);

				for (Student stud : list) {
					bw.write(stud.getStuNum() + ", " + stud.getStuName() + ", " + stud.getEngScore() + ", "
							+ stud.getKorScore());
				}
				bw.close();
				fw.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}

		@Override
		public Student getStudent(int sno) { // 학생번호로 한 건만 조회
			for (int i = 0; i < list.size(); i++) { // list에 담겨있는 건 개수(?)
				if (list.get(i)/* list클래스에 있는 건을 갖고(get)오겠다 */.getStuNum() == sno) {
					return list.get(i); // 같은 학생 번호가 있으면 해당 번호를 student 클래스 리턴
				}
			}
			return null; // 없으면 null 리턴(반환)
		}

		@Override
		public List<Student> studentList() { // 전체 학생 정보를 가져오겠다. 전체 리스트
			return list;
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

		@Override
		public void removeStudent(int stuNo) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getStuNum() == stuNo) {
					list.remove(i); // 리스트 컬렉션에서 해당 칸(i) 삭제
				}
			}
		}

		@Override
		public List<Student> searchStudent(String name) {
			List<Student> searchList = new ArrayList<Student>();
			// 동일한 이름을 찾았다고해서 종료시키면 안됨. 컬렉션에 있는 갯수만큼 반복
			for (int i = 0; i < list.size(); i++) {
				// 같은 이름이 있는지 찾아보고 있으면 searchList.add()로 추가
				if (list.get(i).getStuName().equals(name)) {
					searchList.add(list.get(i));
				}
			}
			return searchList;
		}

	} // StudentServiceImpl 클래스 끝

	// StudentApp에서 만든 기능을 단순히 호출하도록 만든 '메인 기능'을 하는 메소드
	public void execute() {
		StudentService service = new StudentServiceFile(); // 인터페이스 생성. StudentService는 인터페이스, StudentServiceImpl은 구현객체
		// 메뉴 : 1.추가 2.리스트 3.한건조회 4.수정 5.삭제 6.이름조회 9.종료
		while (true) {
			System.out.println("1.추가 2.리스트 3.한건조회 4.수정 5.삭제 6.이름조회 9.종료");
			System.out.print("선택>> ");

			// 메뉴입력
			int menu = scn.nextInt();
			if (menu == 1) {
				// 학생정보 추가입력하기 : 학생번호, 학생이름, 영어점수, 국어점수
				System.out.print("학생번호입력>> ");
				int stuNo = scn.nextInt();
				System.out.print("학생이름입력>> ");
				String stuName = scn.next();
				System.out.print("영어점수입력>> ");
				int engScore = scn.nextInt();
				System.out.print("국어점수입력>> ");
				int korScore = scn.nextInt();

				Student s1 = new Student(stuNo, stuName, engScore, korScore);
				service.insertStudent(s1); // insertStudent 메소드에 매개값 s1 넣어줌. 한 건 입력

			} else if (menu == 2) {
				List<Student> list = service.studentList(); // 리스트컬렉션 리턴
				for (Student s : list) { // 리스트 컬렉션에 담긴 건수만큼 반복하겠다는 뜻
					System.out.println(s.toString());
				}

			} else if (menu == 3) { // 한 건 조회
				System.out.print("조회될 학생번호 입력>> ");
				int stuNo = scn.nextInt();
				Student student = service.getStudent(stuNo);
				if (student == null) {
					System.out.println("조회된 결과가 없습니다.");
				} else {
					System.out.println(student.toString());
				}

			} else if (menu == 4) {
				System.out.print("수정할 학생번호입력>> ");
				int stuNo = scn.nextInt();
				System.out.print("영어점수입력>> ");
				int engScore = scn.nextInt();
				System.out.print("국어점수입력>> ");
				int korScore = scn.nextInt();

				Student s1 = new Student(stuNo, null, engScore, korScore);
				service.modifyStudent(s1);
				System.out.println("처리가 완료되었습니다.");

			} else if (menu == 5) {
				System.out.print("삭제할 학생번호입력>> ");
				int stuNo = scn.nextInt();

				service.removeStudent(stuNo);
				System.out.println("처리가 완료되었습니다.");

			} else if (menu == 6) {
				System.out.print("조회될 학생이름입력>> ");
				String stuName = scn.next();
				List<Student> name = service.searchStudent(stuName);
				if (name.size() == 0) { // '검색한 이름'의 리스트이므로 검색한 이름의 값이 없을 경우, null이 아닌 리스트 값이 0인것이기때문에 name.size = 0으로
										// 입력해야함
					System.out.println("조회된 결과가 없습니다.");
				} else {
					for (Student s : name) {
						System.out.println(s.toString());
					}
				}

			} else if (menu == 9) {
				System.out.println("프로그램을 종료합니다.");
				service.saveToFile();
				break;
			}
		} // while 끝
		System.out.println("끝");

	}

}
