package com.edu.collect0323;

import java.util.List;

public interface StudentService {
	
	public void insertStudent(Student student); // class에 입력할 용도
	public Student getStudent(int sno); // 한건조회
	public List<Student> studentList(); // 전체목록
	public void modifyStudent(Student student); // 한건수정
	
	

}
