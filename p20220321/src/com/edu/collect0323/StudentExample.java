package com.edu.collect0323;

import java.util.ArrayList;
import java.util.List;

public class StudentExample {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		
		Student s1 = new Student(101, "홍길동", 70, 73);
		Student s2 = new Student(102, "김주환", 80, 85);
		Student s3 = new Student(103, "이재학", 84, 88);
		
		// 추가
		list.add(s1); // add->저장
		list.add(s2);
		list.add(s3);
		
		Student result = list.get(0); // 리스트 첫번째 학생 점수 보기 위해 변수 result 선언
		System.out.println("첫번째 학생: " + result.toString());
		
		// 수정
		list.set(0, new Student(201, "서현일", 90, 92)); // 첫번째 인스턴스 자체를 변경
		result = list.get(0); // get해줘야 바꾼 위치의 값을 불러와서 result에 담음
		
		list.get(0).setKorScore(100); // 첫번째 인스턴스가 갖고 있는 '값'을 변경
		list.get(0).setEngScore(100);
		
		// 삭제
		list.remove(0); // 삭제처리
		
		System.out.println("첫번째 학생: " + list.get(0).toString());
		
	
		
	}

}
