package com.prod0329;

import java.sql.*;

// 오라클에서 제공해주는 library=ojdbc라이브러리
// 오라클db와 ojdbc라이브러리 연결(db접속주소, hr, hr 필요), Connection 객체 이용
// Connection 객체 이용하여 query 실행 -> query실행 기능 담고있는 클래스 : Statement, PreparedStatement
public class JDBCSample {
	// 필드
	// DriverManager
	static Connection conn;
	static Statement stmt;
	static ResultSet rs;
	static PreparedStatement psmt;

	// getConnect 메소드
	public static Connection getConnect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		System.out.println("연결성공!!");
		return conn; // 만들어진 connection객체 리턴

	}

	// disconnect 메소드
	public static void disconnect() {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 메인 메소드
	public static void main(String[] args) {
		conn = getConnect(); // getConnect()메소드 호출해서 connection(conn)객체 만들어주는 작업

		// Statement 생성
		try {
//			stmt = conn.createStatement(null); // 만들어준 conn객체로 statement객체 만들어서 아랫줄 executeQuery로 쿼리실행
			
			// 입력(사원번호, last_name, 입사일자, email, job_id)
			int emp_id = 302;
			String last_name = "홍길동";
			String hire_date = "2020-03-05";
			String email = "Kdong@email.com";
			String job = "IT_PROG";

			String fn = "kildong";
			String pn = "010-xxxx-7xx4";
			int salary = 6000;

			String sql = "delete from emp_java\r\n"
					+ "where employee_id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, emp_id);
			
//			psmt.setString(1, fn); // 1번째 물음표는 fn(first_name)으로 하겠다
//			psmt.setString(2, pn);
//			psmt.setInt(3, salary);
//			psmt.setInt(4, emp_id);
			
			int r = psmt.executeUpdate(); // 입력&수정&삭제시에는 Update사용
			System.out.println(r + "건 삭제됨");

			// 조회
//			rs = stmt.executeQuery("select * from emp_java order by employee_id"); // return값 설정 / select -> 조회 / 데이터 보유 여부 확인
//			while (rs.next()) { // next()->갖고 올 데이터가 있는지 물어보고 있으면 한 건 가져오고, 없으면 false
//				System.out.println("사원번호: " + rs.getInt("employee_id")); employee안의 값을 가져오겠다
//				System.out.println("이름: " + rs.getString("first_name"));
//			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		disconnect(); // 연결끊기
	}
}
