package com.edu.collect0323;

import java.util.List;

public interface StudentService { // 아래와 같은 기능을 구현하도록 규칙 지정. 기능은 인터페이스와 연결된 곳에서 구현
	
	public void insertStudent(Student student); // class에 입력할 용도
	public Student getStudent(int sno); // 한건조회
	public List<Student> studentList(); // 전체목록
	public void modifyStudent(Student student); // 한건수정
	public void removeStudent(int stuNo); // 한건삭제
	public List<Student> searchStudent(String name); // 이름조회, 여러건 조회를 위해 List<Student> 컬렉션타입으로 반환 설정
	public void saveToFile();

	

}
