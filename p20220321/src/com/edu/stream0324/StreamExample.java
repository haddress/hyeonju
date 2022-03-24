package com.edu.stream0324;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Consumer;
import java.util.stream.Stream;

class Student implements Comparable<Student> {
	String name;
	String gender;
	int score;
	int point;

	// 생성자
	public Student(String name, String gender, int score) {
		super();
		this.name = name;
		this.gender = gender;
		this.score = score;
	}

	public Student(String name, String gender, int score, int point) {
		super();
		this.name = name;
		this.gender = gender;
		this.score = score;
		this.point = point;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", gender=" + gender + ", score=" + score + "]";
	}

	@Override
	public int compareTo(Student student) {
		// this와 student 비교: this, student => 음수출력일경우 오름차순 정렬 / student, this => 양수출력일경우
		// 내림차순 정렬
//		if (this.score < student.score) {
//			return 1;
//		} else {
//			return -1;
//		}
		return (this.score + this.point) - (student.score + student.point); // ex) this.score가 60, student.score가 70일 경우 -한 값이 음수값이 나오므로 오름차순 정렬 
		// 음수일 경우 뒤로갈수록 큰 값을 정렬하겠다는 것(오름차순)
	}

}

public class StreamExample {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("홍길동", "남자", 70));
		list.add(new Student("김순희", "여자", 80));
		list.add(new Student("김부식", "남자", 85));
		list.add(new Student("박한나", "여자", 88));

		// 평균구하기
		int sum = 0, cnt = 0;
		double avg = 0;
		for (Student/* 컬렉션 안에 들어있는 타입과 같야아 함 */ student : list) {
			if (student.gender.equals("남자")) {
				sum += student.score;
				cnt++;
			}
		}
		avg = sum / (double) cnt;
		System.out.println("컬렉션평균: " + avg);

		// 스트림
		Stream<Student> stream = list.stream(); // 스트림 생성
		// filter => 조건에 해당되지 않는 요소들을 제외함
		OptionalDouble od = stream.filter((s) -> s.gender.equals("남자")).mapToInt(s -> s.score).average();

		avg = od.getAsDouble();
		System.out.println("스트림평균: " + avg);

//		stream.forEach((Student t) -> {
//			System.out.println("이름: " + t.name + ", 성별" + t.gender + ", 점수: " + t.score);

//		stream.forEach(new Consumer<Student>() { // 스트림에 들어있는 각각의 데이터에 대해 Student라는 매개값을 받아서 들어있는 기능 실행
//
//			@Override
//			public void accept(Student t) { // Student 클래스의 이름, 성별, 점수 출력하는 기능
//				System.out.println("이름: " + t.name + ", 성별" + t.gender + ", 점수: " + t.score);
//			}
//		

//		});
	}

}
