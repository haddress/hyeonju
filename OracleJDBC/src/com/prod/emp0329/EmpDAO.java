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
				emp.setPhoneNumber(rs.getString("phone_number"));

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
	public Employee getEmp(int employeeId) {

		conn = getConnect();
		Employee emp = null;
		String sql = "SELECT* from emp_java " + "where employee_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, employeeId);
			rs = psmt.executeQuery();
			if (rs.next()) { // 한 건 조회니까 while문 안써도 됨!
				emp = new Employee(); // 인스턴스 만들기
				emp.setEmployeeId(rs.getInt("employee_id")); // setEmployeeId 메소드로 아이디 set 해줌. int타입으로
																// employees.employee_id 읽어오겠다는 뜻
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setSalary(rs.getInt("salary"));
				emp.setHireDate(rs.getString("hire_date").substring(0, 10));
				emp.setJobId(rs.getString("job_id"));
				emp.setPhoneNumber(rs.getString("phone_number"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return emp;
	}

	// 입력처리 executeUpdate()
	public boolean insertEmp(Employee emp) {
		conn = getConnect();
		String sql = "INSERT into emp_java (employee_id, last_name, email, hire_date, job_id)  "
				+ "VALUES (?, ?, ?, ?, ?)";

		try {
			psmt = conn.prepareStatement(sql); // ?에 들어갈 값 <= 매개변수값 중에서 employeeId 필드값을 대체해서 넣을 것
			psmt.setInt(1, emp.getEmployeeId());
			psmt.setString(2, emp.getLastName());
			psmt.setString(3, emp.getEmail());
			psmt.setString(4, emp.getHireDate());
			psmt.setString(5, emp.getJobId());
			int r = psmt.executeUpdate(); // 조회할 때 : executeQuery, 입력 : executeUpdate
			System.out.println(r + "건 입력!!");
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			// 정상실행, 예외발생에 상관없이 반드시 실행되는 코드
			disconnect();
		}
		return false;
	}

	// 수정처리
	public String updateEmp(Employee emp) { // void는 처리될 반환값이 없음
		conn = getConnect();
		String sql = "update emp_java " + "set first_name = ?, " + "    phone_number = ?, " + "    salary = ? "
				+ "where employee_id = ?"; // 쿼리 작성 => ? 작성
		try {
			psmt = conn.prepareStatement(sql);
			// 파라메터 값을 지정함
			psmt.setString(1, emp.getFirstName());
			psmt.setString(2, emp.getPhoneNumber());
			psmt.setInt(3, emp.getSalary());
			psmt.setInt(4, emp.getEmployeeId());

			int r = psmt.executeUpdate(); // 쿼리를 실행하는 구문
			System.out.println(r + "건 수정!!");
			if (r > 0) {
				return "OK"; // 메소드 값이 boolean일 경우 문자열인 "OK"불가능. true / false만 이용 가능
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return "NG";
	}

	// 삭제처리
	public void deleteEmp(int empId) { // id 기준 한 건 삭제
		conn = getConnect();
		String sql = "delete from emp_java " + "where employee_id = ?"; // 쿼리 작성 => ? 작성
		try {
			psmt = conn.prepareStatement(sql);
			// 파라메터 값을 지정
			psmt.setInt(1, empId);

			int r = psmt.executeUpdate(); // 쿼리를 실행하는 구문
			System.out.println(r + "건 삭제!!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

}
