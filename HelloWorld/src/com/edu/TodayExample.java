package com.edu;
// 이름을 입력받도록...(String) -> scn.nextLine();
// 연락처 입력...(String) -> scn.nextLine();
// 나이 입력...(int) -> scn.nextInt();
// 키 입력...(double) -> scn.nextDouble();

import java.util.Scanner;

// 이름 : ???
// 연락처 : 010-2345-6789
// 나이 : 28
// 키 : 165.2
// 몸무게 : 58
// 적정몸무게 : (키 -100) * 0.9 => ?? 보다 크면 과체중 적으면 저체중
// +- 5키로

public class TodayExample {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("이름을 입력하세요.");
		String name = scn.nextLine();
		System.out.println("연락처를 입력하세요.");
		String number = scn.nextLine();
		System.out.println("나이를 입력하세요.");
		int age = scn.nextInt();
		System.out.println("키를 입력하세요.");
		double height = scn.nextDouble();
		System.out.println("몸무게를 입력하세요.");
		double weight = scn.nextDouble();
		
		System.out.println();
		System.out.println("이름 : " + name);
		System.out.println("연락처 : " + number);
		System.out.println("나이 : " + age);
		System.out.println("키 : " + height);
		System.out.println("몸무게 : " + weight);
		
		double goodkg = (height - 100) * 0.9;
			if(weight > goodkg + 5) {
				System.out.println("과체중입니다ㅠㅠ.");
			} else if(weight < goodkg - 5){
				System.out.println("저체중입니다ㅠㅠ.");
			} else {
				System.out.println("적정체중입니다!");
			}
		
		
//		 double Weight = 67.5; // 72.5~62.5 사이 적정
//		 double realWeight = 69.3;
//		 if(Weight + 5 > realWeight && Weight - 5 < realWeight) {
//			System.out.println("적정몸무게입니다.");
//		 } else {
//			 System.out.println("비정상입니다.");
//		 }
		
		scn.close();
	}

}
