package com.edu.lambda0324.consumer;

import java.util.function.ToIntFunction;

import com.edu.collect0323.Student;

// Function 인터페이스 : 매핑작업을 할 때, (Student -> int)
public class FunctionExample {
	public static void main(String[] args) {
		ToIntFunction<Student> func = (student) -> student.getEngScore() + student.getKorScore();
		int result = func.applyAsInt(new Student(101, "Hong", 80, 90));
		System.out.println("결과값: " + result);
	}

}
