package com.prod.emp0329;

import java.util.List;
import java.util.Scanner;

public class EmpExe {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		EmpDAO dao = new EmpDAO();

		// 메뉴: 1.사원리스트 2.입력 3.수정 4.삭제 5.한건조회 9.종료

		while (true) {
			System.out.println("===================================================");
			System.out.println("1.사원리스트 | 2.입력 | 3.수정 | 4.삭제 | 5.한건조회 | 9.종료");
			System.out.print("메뉴선택>> ");

			int menu = scn.nextInt();
			if (menu == 1) { // 전체사원리스트
				List<Employee> list = dao.empList(); // 전체 조회하는 기능

				System.out.println("===================================================");
				System.out.println("<사원리스트>");
				for (Employee emp : list) {
					System.out.println(emp.toString());
					System.out.println();
				}

			} else if (menu == 2) { // 입력
				// 사원번호, lastName, email, hireDate, jobId

				System.out.println("사원번호입력>> ");
				int employeeId = scn.nextInt();
				System.out.println("이름(성)입력>> ");
				String lastName = scn.next();
				System.out.println("이메일입력>> ");
				String email = scn.next();
				System.out.println("고용일자입력>> ");
				String hireDate = scn.next();
				System.out.println("직급입력>> ");
				String jobId = scn.next();

				// 방법(1) : 기본생성자 + 생성자 + emp 선언
				Employee emp = new Employee(employeeId, null, lastName, email, 0, hireDate, jobId, null); // 파라메터를 사원번호, lastName...각각 담지 않기 위해 employee 클래스를 선언하여 emp로 지정
				
				// 방법(2) : set메소드 이용해서 필드 입력
//				Employee emp = new Employee();
//
//				emp.setEmployeeId(employeeId);
//				emp.setLastName(lastName);
//				emp.setEmail(email);
//				emp.setHireDate(hireDate);
//				emp.setJobId(jobId);

				boolean tOrf = dao.insertEmp(emp); // boolean 타입으로 결과값을 받아와서
				if (tOrf) { // 메소드가 boolean값
					System.out.println("정상적으로 처리되었습니다.");
				} else {
					System.out.println("오류가 발생하였습니다.");
				}
				

			} else if (menu == 3) { // 수정
				// 사원번호, 전화번호, firstName, salary
				System.out.println("수정할 사원번호 입력>> ");
				int employeeId = scn.nextInt();
				System.out.println("전화번호입력>> ");
				String phoneNumber = scn.next();
				System.out.println("이름입력>> ");
				String firstName = scn.next();
				System.out.println("연봉입력>> ");
				int salary = scn.nextInt();

				Employee emp = new Employee();

				// 생성자
				// set메소드
				emp.setEmployeeId(employeeId);
				emp.setPhoneNumber(phoneNumber);
				emp.setFirstName(firstName);
				emp.setSalary(salary);

				String result = dao.updateEmp(emp);
				if(result.equals("OK")) { // 메소드가 String값
					System.out.println("정상적으로 처리되었습니다.");
				} else {
					System.out.println("오류가 발생하였습니다.");
				}

			} else if (menu == 4) { // 삭제
				// 삭제할 사원번호
				System.out.println("삭제할 사원번호 입력>> ");
				int employeeId = scn.nextInt();

				Employee empId = new Employee();
				empId.setEmployeeId(employeeId);

				dao.deleteEmp(employeeId);

			} else if (menu == 5) { // 한건조회
				System.out.println("조회할 사원번호 입력>> ");
				int employeeId = scn.nextInt();

				Employee emp = dao.getEmp(employeeId);
				if (emp == null) {
					System.out.println("조회된 사원번호가 없습니다.");
				} else {
					System.out.println(emp.toString());
				}

			} else if (menu == 9) { // 종료
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		} // end of while
		
		System.out.println("end of program");
		scn.close();

	} // end of main
}
