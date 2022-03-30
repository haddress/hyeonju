package com.edu.collect0323;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceOracle extends DAO implements StudentService {

	@Override
	public void insertStudent(Student student) { // 입력
		conn = getConnect();
		String sql = "INSERT INTO student_info (student_no, student_name, eng_score, kor_score) "
				+ "VALUES(?, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, student.getStuNum());
			psmt.setString(2, student.getStuName());
			psmt.setInt(3, student.getEngScore());
			psmt.setInt(4, student.getKorScore());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력!!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

	@Override
	public Student getStudent(int stuNum) { // 한건조회
		conn = getConnect();
		Student student = null;
		String sql = "SELECT*FROM student_info " + "WHERE student_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, stuNum);
			rs = psmt.executeQuery();
			if (rs.next()) {
				student = new Student();
				student.setStuNum(rs.getInt("student_no"));
				student.setStuName(rs.getString("student_name"));
				student.setEngScore(rs.getInt("eng_score"));
				student.setKorScore(rs.getInt("kor_score"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return student;

	}

	@Override
	public List<Student> studentList() { // 전체조회
		List<Student> list = new ArrayList<Student>(); // 조회된 결과값을 담기 위한 컬렉션 형성
		conn = getConnect();
		String sql = "select * from student_info order by student_no";
		try { // 원래는 new Student() <- 이렇게 생성자를 통해 인스턴스를 만들었음.
				// 지금은 DAO를 상속받았으므로
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery(); // 실행건수만큼 반복자
			while (rs.next()) { // 반복자를 통해 요소를 가지고 올 수 있는지 체크한다. 요소가 있으면 가지고 옴
				Student student = new Student();
				student.setStuNum(rs.getInt("student_no"));
				student.setStuName(rs.getString("student_name"));
				student.setEngScore(rs.getInt("eng_score"));
				student.setKorScore(rs.getInt("kor_score"));

				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return list;
	}

	@Override
	public void modifyStudent(Student student) { // 한건수정
		conn = getConnect();
		String sql = "update student_info " + "set eng_score=?, " + "     kor_score=? " + "WHERE student_no=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, student.getEngScore());
			psmt.setInt(2, student.getKorScore());
			psmt.setInt(3, student.getStuNum());
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건 수정!!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
	}

	@Override
	public void removeStudent(int stuNum) { // 한건삭제
		conn = getConnect();
		String sql = "DELETE FROM student_info "
				+ "WHERE student_no=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, stuNum);
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제!!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

	@Override
	public List<Student> searchStudent(String stuName) { // 이름조회
		List<Student> searchList = new ArrayList<Student>();
		
		conn = getConnect();
		Student student = null;
		String sql = "SELECT*FROM student_info "
				+ "WHERE student_name = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, stuName);
			rs = psmt.executeQuery();
			while (rs.next()) {
				student = new Student();
				student.setStuNum(rs.getInt("student_no"));
				student.setStuName(rs.getString("student_name"));
				student.setEngScore(rs.getInt("eng_score"));
				student.setKorScore(rs.getInt("kor_score"));
				
				searchList.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return searchList;
	}

	@Override
	public void saveToFile() {

	}

}
