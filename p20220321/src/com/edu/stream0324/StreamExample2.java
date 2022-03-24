package com.edu.stream0324;

import java.util.ArrayList;
import java.util.List;

public class StreamExample2 {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("홍길동", "남자", 70, 100)); //170
		list.add(new Student("김순희", "여자", 80, 120)); //200
		list.add(new Student("김부식", "남자", 85, 95)); //180
		list.add(new Student("박한나", "여자", 88, 99)); //187
		
		// 남녀 상관없이 스코어+포인트 > 180 이상인 학생들만 출력
		list
		.stream()
//		.filter(student -> (student.score + student.point) >= 180)
		.sorted() // Comparable 구현하는 클래스
		.forEach(student -> System.out.println(student)); // 필터링된 대상 출력
		
		System.out.println("========================");
		list // 컬렉션으로부터
		.stream() // 스트림생성
		.filter(student -> student.score >= 80) // 80점 이상인 대상을 필터.거르기
		.filter(student -> student.gender.equals("여자")) // "여자"만 필터링
		.forEach(student -> System.out.println(student)); // 필터링된 대상 출력
	}

}
