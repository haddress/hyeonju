package com.edu.except0321;

import java.util.InputMismatchException;
import java.util.Scanner;

// 클래스A, 클래스B...클래스Z
// 클래스 main => main 메소드 포함


public class LibraryExe {
	private static LibraryExe singleton = new LibraryExe(); // private로 singleton 외부에서 접근 불가
	private LibraryExe() {
		
	}
	
	public static LibraryExe getInstance() { // getInstance는 정적메소드. singleton이 LibraryExe 안에서 getInstane 메소드로 호출해야 사용 가능
		return singleton;
		
	}
	
//	public static void main(String[] args) {
	public void run() {
		// 책 체목, 저자, 가격 -> 저장
		// 리스트 보여주기

		Scanner scn = new Scanner(System.in);

		Book[] library = new Book[5];
		while (true) {
			
			int menu = 0;

			while (true) {
				try {
					showMessage("메뉴선택: 1.책정보입력 | 2.리스트보기 | 3.종료");
					menu = scn.nextInt();
					break;
				} catch (InputMismatchException e) {
					System.out.println("숫자를 입력하세요.");
					scn.next();
				}
			}

			if (menu == 1) {
				showMessage("책 제목 입력>>");
				String title = scn.next();
				showMessage("책 저자 입력>>");
				String author = scn.next();
				int price = 0;
				while (true) {
					try {
						showMessage("책 가격 입력>>");
						price = scn.nextInt();
						break;
					} catch (InputMismatchException e) {
						System.out.println("숫자를 입력하세요.");
						scn.next();
						
					}
				}

				Book book = new Book(title, author, price);
				for (int i = 0; i < library.length; i++) {
					if (library[i] == null) {
						library[i] = book;
						break;
					}
				}
				showMessage("저장완료.\n");

			} else if (menu == 2) {
				for (int i = 0; i < library.length; i++) {
					if (library[i] == null) {
						library[i].showInfo(); // 책제목, 저자, 가격...
					}
				}

			} else if (menu == 3) {
				showMessage("프로그램을 종료합니다.");
				break;
			}

		} // end of while()
		showMessage("=== end of program ===");
	}

	public static void showMessage(String str) {
		for (int i = 0; i < str.length(); i++) {
			System.out.print(str.charAt(i));
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
