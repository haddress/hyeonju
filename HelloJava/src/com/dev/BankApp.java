package com.dev;

import java.util.Scanner;

// BankApp(main method), Account(계좌번호, 예금주, 잔액)->배열을 사용해서 여러명으로
public class BankApp {

	static Account[] banks = new Account[100];
	static Scanner scn = new Scanner(System.in);

	// 메뉴: 1.계좌생성(계좌번호, 예금주, 예금액)
	// 2.예금(계좌번호, 예금액) -> 최고예금액 100,000원
	// 3.출금(계좌번호, 출금액) -> 잔액보다 큰 금액은 출금 못하도록
	// 4.잔액조회(계좌번호)
	// 5.종료

	// 메인
	public static void main(String[] args) {

		while (true) {
			printMenu();
			int menu = scn.nextInt();
			if (menu == 1) {
				createAccount();
			} else if (menu == 2) {
				deposit();
			} else if (menu == 3) {
				withdraw();
			} else if (menu == 4) {
				findAccountMoney();
			} else if (menu == 5) {
				transferAmount();
			} else if (menu == 6) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else if (menu == 9) {
				showList();
			}
		}

		System.out.println("=== End of Prog ===");
	} // end of main()

	// 메뉴 출력 기능
	public static void printMenu() {
		String menu = "================================================================\r\n"
				+ "\t1.계좌생성(계좌번호, 예금주, 예금액)\r\n" + "\t2.예금(계좌번호, 예금액) -> 최고예금액 100,000원\r\n"
				+ "\t3.출금(계좌번호, 출금액) -> 잔액보다 큰 금액은 출금 못하도록\r\n" + "\t4.잔액조회(계좌번호)\r\n" + "\t5.송금(송금번호, 금액, 입금계좌번호)\r\n"
				+ "\t6.종료\r\n" + "================================================================\r\n" + "선택> ";
		System.out.print(menu);
	}

	// 계좌 생성 메소드
	public static void createAccount() {
		System.out.println("계좌 생성 기능");
		String accNo;

		while (true) {
			System.out.print("계좌번호입력>> ");
			accNo = scn.next();

			// 계좌번호 있는지 체크

			if (searchAccountNo(accNo) != null) {
				System.out.println("이미 있는 계좌번호입니다. 다른 계좌번호를 입력하세요.");
				continue;
			}
			break;
		}

		System.out.print("예금주입력>> ");
		String accName = scn.next();
		System.out.print("예금액입력>> ");
		int accMoney = scn.nextInt();

		Account accnt = new Account(accNo, accName, accMoney);

		for (int i = 0; i < banks.length; i++) {
			if (banks[i] == null) {
				banks[i] = accnt;
				break;
			}
		}
		System.out.println("계좌가 정상적으로 생성되었습니다.");
	}

	// 예금 메소드
	public static void deposit() {
		System.out.println("예금 기능");
		while (true) {
			System.out.print("계좌번호>> ");
			String ano = scn.next();
			if (searchAccountNo(ano) != null) {
				int currAmt = searchAccountNo(ano).getMoney();
				while (true) {
					System.out.println("예금액 입력>>");
					int amt = scn.nextInt();
					if (currAmt + amt > 100000) {
						System.out.println("예금 한도액을 초과하였습니다.");
					} else if (currAmt + amt <= 100000) {
						System.out.println("예금이 정상적으로 처리되었습니다.");
						searchAccountNo(ano).setMoney(currAmt + amt);
						break;
					}

				}
				break;
			}
			System.out.println("계좌번호를 다시 입력해주세요.");
		}

//		<방법1-1>
//		System.out.print("계좌번호>> ");
//		String ano = scn.next();
//		System.out.print("예금액 입력>>");
//		int amt = scn.nextInt();
//		int checkCnt = 0; // 조회가 됐는지 여부를 체크하는 변수
//		Account myAcc = searchAccountNo(ano);
//		if (myAcc != null) {
//			checkCnt = 1;
//			int currAmt = myAcc.getMoney();
//			
//			if(currAmt + amt > 100000) {
//				checkCnt = 2;
//			} else {
//				myAcc.setMoney(currAmt + amt);
//			}
//		}
//		
//		if (checkCnt == 1) {
//			System.out.println("정상적으로 처리되었습니다.");
//		} else if (checkCnt == 2) {
//			System.out.println("예금 한도액을 초과하였습니다.");
//		} else {
//			System.out.println("계좌번호를 찾을 수 없습니다.");
//		}

//		<방법 1-2>		
//		System.out.print("계좌번호>> ");
//		String ano = scn.next();
//		System.out.print("예금액 입력>>");
//		int amt = scn.nextInt();
//		for (int i = 0; i < banks.length; i++) {
//			if (banks[i] != null && banks[i].getAccNo().equals(ano)) { // 계좌번호가 있을 경우
//				// 계좌번호가 조회됐을 때 실행되도록
//				checkCnt = 1;
//				int currAmt = banks[i].getMoney();
//				// 계좌번호과 10만원을 초과하지 못하도록 넣는 명령문
//				if (currAmt + amt > 100000) {
//					checkCnt = 2;
//					break;
//				}
//				banks[i].setMoney(currAmt + amt); // 잔액 + 입금액
//				break;
//			}
//		}

//		if (checkCnt == 1) {
//			System.out.println("정상적으로 처리되었습니다.");
//		} else if (checkCnt == 2) {
//			System.out.println("예금 한도액을 초과하였습니다.");
//		} else {
//			System.out.println("계좌번호를 찾을 수 없습니다.");
//		}

	}

	// 출금 메소드
	public static void withdraw() {
		System.out.println("출금 기능");
		while (true) {
			System.out.print("계좌번호>> ");
			String ano = scn.next();
			if (searchAccountNo(ano) != null) {
				int currAmt = searchAccountNo(ano).getMoney();
				while (true) {
					System.out.println("출금액 입력>>");
					int amt = scn.nextInt();
					if (currAmt < amt) {
						System.out.println("출금 한도액을 초과하였습니다.");
					} else if (currAmt >= amt) {
						System.out.println("출금이 정상적으로 처리되었습니다.");
						searchAccountNo(ano).setMoney(currAmt - amt);
						break;
					}

				}
				break;
			}
			System.out.println("계좌번호를 다시 입력해주세요.");
		}

//		System.out.println("계좌번호>> ");
//		String ano = scn.next();
//		System.out.println("출금액 입력>> ");
//		int amt = scn.nextInt();
//
//		int checkCnt = 0;
//		for (int i = 0; i < banks.length; i++) {
//			if (banks[i] != null && banks[i].getAccNo().equals(ano)) {
//				checkCnt = 1;
//				int currAmt = banks[i].getMoney();
//				if (currAmt < amt) {
//					checkCnt = 2;
//					break;
//				}
//				banks[i].setMoney(currAmt - amt);
//				break;
//			}
//		}
//		if (checkCnt == 1) {
//			System.out.println("정상적으로 처리되었습니다.");
//		} else if (checkCnt == 2) {
//			System.out.println("잔액이 부족합니다.");
//		} else {
//			System.out.println("계좌번호를 찾을 수 없습니다.");
//		}

	}

	// 잔액조회 메소드
	public static void findAccountMoney() {
		System.out.println("조회 기능");
		while (true) {
			System.out.println("계좌번호>> ");
			String ano = scn.next();
			if (searchAccountNo(ano) != null) {
				Account myAcc = searchAccountNo(ano);
				System.out.println("현재 잔액은 " + myAcc.getMoney() + "원 입니다.");
				break;
			}
			System.out.println("계좌번호를 다시 입력해주세요.");
		}

	}

	// 송금 메소드
	public static void transferAmount() {
		System.out.println("송금 기능");
		System.out.print("계좌번호>>");
		String ano = scn.next();
		Account sendAcc = searchAccountNo(ano);
		if (sendAcc != null) {
			int sendAmt = sendAcc.getMoney();
			System.out.println("송금하실 금액을 입력하세요.");
			int amt = scn.nextInt();
			if (sendAmt < amt) {
				System.out.println("잔액이 부족합니다.");
				return;
			} else {
				while (true) {
					System.out.println("받으시는 분의 계좌번호를 입력하세요.");
					String ano2 = scn.next();
					Account receiveAcc = searchAccountNo(ano2);
					if (receiveAcc != null) {
						int receiveAmt = receiveAcc.getMoney();
						receiveAcc.setMoney(receiveAmt + amt);
						System.out.println("송금이 정상적으로 처리되었습니다.");
						break;
					} else {
						System.out.println("계좌번호를 다시 입력해주세요.");
					}
				}

			}

		}

	}

	// 전체 리스트 출력
	public static void showList() {
		for (int i = 0; i < banks.length; i++) {
			if (banks[i] != null) {
				System.out.println(banks[i].toString());
			}
		}

	}

	// 계좌번호를 입력하면 배열(banks)에서 그 계좌번호를 반환, 없으면 null
	// 100개 중에 35개 저장이면. 75개는 비어있는 값
	// 계좌번호를 넣으면 계좌를 바로 꺼내주는 메소드
	public static Account searchAccountNo(String accNo) {
		for (int i = 0; i < banks.length; i++) {
			if (banks[i] != null && banks[i].getAccNo().equals(accNo)) {
				return banks[i];

			}
		}
		return null; // 클래스 -> null(Student, Car,
	}

}
