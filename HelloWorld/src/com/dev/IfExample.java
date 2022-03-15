package com.dev;

import java.util.Scanner;

public class IfExample { //WhichExample -> class 첫 글자는 대문자로 , 'firstName, first_name'->에러는 안나지만 자바에서는 잘 안씀

	public static void main(String[] args) {
		// 조건문 if ..조건을 만족하는지
		//60점 이상이면 Pass
		int score = 83;
		if(score > 60) {
			System.out.println("Pass입니다.");
		} else {
			System.out.println("Fail입니다.");
		}
		
		// 90점 이상이면 A, 80이상 B, 70이상 C, 60이상 D, 그 외에는 F
		if(score >= 90) {
			if(score >= 95) {
				System.out.println("A+입니다.");
			} else {
				System.out.println("A입니다.");
			}
		} else if(score >= 80) {
			if(score >= 85) {
				System.out.println("B+입니다.");
			} else {
				System.out.println("B입니다.");
			}
		} else if(score >= 70) {
			if(score >=75) {
				System.out.println("C+입니다.");
			} else {
				System.out.println("C입니다.");
			}
		} else if(score >= 60) {
			if(score >= 65) {
				System.out.println("D+입니다.");
			} else {
				System.out.println("D입니다.");
			}
		} else {
			System.out.println("F입니다.");
		}
		
		System.out.println("end of Program");
	}

}
