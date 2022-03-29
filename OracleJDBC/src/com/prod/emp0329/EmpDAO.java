package com.prod.emp0329;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO extends DAO {
	// 전체조회
	public List<Employee> empList() {
		List<Employee> employees = new ArrayList<Employee>();

		conn = super.getConnect();
		try {
			psmt = conn.prepareStatement("select * from emp_java");
			rs = psmt.executeQuery();
			while (rs.next()) {
				Employee emp = new Employee(); // 인스턴스 만들기
				emp.setEmployeeId(rs.getInt("employee_id")); // setEmployeeId 메소드로 아이디 set 해줌. int타입으로
																// employees.employee_id 읽어오겠다는 뜻
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setSalary(rs.getInt("salary"));
				emp.setHireDate(rs.getString("hire_date").substring(0, 10));
				emp.setJobId(rs.getString("job_id"));

				employees.add(emp); // 건수 있는 만큼 while 하면서 계속 값을 담기
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return employees;
	}

	// 한건조회

	// 입력처리

	// 수정처리

	// 삭제처리

}
