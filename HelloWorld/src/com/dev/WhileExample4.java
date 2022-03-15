package com.dev;

import java.util.Scanner;

public class WhileExample4 {
	public static void main(String[] args) {
		// 은행 계좌를 만들어서 1번을 누르면 입금, 2:출금, 3:종료
		// 입금일 경우: "입금액을 입력하세요" 출력...account 값을 누적
		// 출금일 경우: "출금액을 입력하세요" 출력...account 값을 차감
		// 종료일 경우: 프로그램 종료
		
		// Scanner 실행, account 초기화
		// While 반복문
		
		Scanner scn = new Scanner(System.in);
		
		int account = 0;
		
		while(true) {
			System.out.println("반갑습니다.");
			System.out.println("-----------------------");
			System.out.println("1:입금 / 2:출금 / 3:종료");
			System.out.println("-----------------------");
			System.out.print("선택> ");
			int menu = scn.nextInt();
				if(menu == 1) {
					System.out.println("입금액을 입력하세요.");
					int input = scn.nextInt();
					account += input;
					System.out.println("현재 잔액은 " + account + "원입니다.");
					System.out.println("-----------------------");
					System.out.println("명세표를 출력하시겠습니까?");
					System.out.println("1:네 / 2:아니오");
					System.out.println("-----------------------");
					System.out.print("선택> ");
					int bill = scn.nextInt();
						if(bill == 1) {
							System.out.println("-----------------------");
							System.out.println("명세표 : " + input + "원");
							System.out.println("잔액 : " + account + "원");
							System.out.println("-----------------------");
							continue; // 구문 아래를 무시하고 다음 순번으로 넘어감 (프로그램을 끝내지 않고 다음 while 반복구문으로)
						} else {
							System.out.println();
							continue;
						}
				} else if(menu == 2) {
					System.out.println("출금액을 입력하세요.");
					int output = scn.nextInt();
						if(output > account) {
							System.out.println("잔액이 부족합니다.");
							continue;
						}
					account -= output;
					System.out.println("현재 잔액은 " + account + "원 입니다.");
					System.out.println("-----------------------");
					System.out.println("명세표를 출력하시겠습니까?");
					System.out.println("1:네 / 2:아니오");
					System.out.println("-----------------------");
					System.out.print("선택> ");
					int bill = scn.nextInt();
						if(bill == 1) {
							System.out.println("-----------------------");
							System.out.println("명세표 : " + output + "원");
							System.out.println("잔액 : " + account + "원");
							System.out.println("-----------------------");
							continue;
						} else {
							continue;
						}
				} else if(menu == 3) {
					break;
				}
				
//				switch(menu) {
//				case 1:
//					System.out.println("입금액을 입력하세요.");
//					int input = scn.nextInt();
//					account += input;
//					System.out.println("현재 잔액은 " + account + "원 입니다.");
//					continue;
//				case 2:
//					System.out.println("출금액을 입력하세요.");
//					int output = scn.nextInt();
//					account -= output;
//					System.out.println("현재 잔액은 " + account + "원 입니다.");
//					continue;
//				case 3:
//					break;
//				}
				
				
		}
	
		System.out.println("이용해주셔서 감사합니다.");
		
		
	}

}
