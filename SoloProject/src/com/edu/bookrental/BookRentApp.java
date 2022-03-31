package com.edu.bookrental;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookRentApp {

	// 도서컬렉션 필드
	List<Book> books = new ArrayList<Book>();

	Scanner scn = new Scanner(System.in);

	// 내부클래스

	// execute() : 앱 실행하는 메인메소드
	public void execute() {
		BookService service = new BookServiceImpl();

		// 로그인 기능-----------------------------------
		while (true) {
			System.out.println("\t\t로그인이 필요합니다.");
			System.out.println("\t\t===================");
			System.out.print("\t\tID: ");
			String id = scn.next();
			System.out.print("\t\tPW: ");
			String pw = scn.next();
			System.out.println("\t\t===================");

			int result = service.logIn(id, pw);
			if (result == 1) {
				System.out.println("\t\t로그인에 성공하였습니다!");
				System.out.println();
				break;
			} else if (result == 0) {
				System.out.println("\t\t비밀번호가 일치하지 않습니다.");
				System.out.println();
			} else if (result == -1) {
				System.out.println("\t\t존재하지 않는 아이디입니다.");
				System.out.println();
			} else if (result == -2) {
				System.out.println("\t\tDB 오류");
				System.out.println();
			}
		}
		// --------------------------------------------

		// 어플 첫 화면-----------------------------------
		while (true) {
			System.out.println("");
			System.out.println("\t\t===================");
			System.out.println("\t\t1.도서목록 | 2.검색 | 3.대여 | 4.반납 | 5.도서등록 | 6.마이페이지 | 9.종료");
			System.out.print("\t\t선택>> ");

			// 메뉴입력----------------------------------
			int menu = scn.nextInt();
			System.out.println();
			if (menu == 1) { // 도서목록
				List<Book> bookList = service.bookList();
				for (Book b : bookList) {
					System.out.println(b.toString());
				}

			} else if (menu == 2) { // 검색

			} else if (menu == 3) { // 대여

			} else if (menu == 4) { // 반납

			} else if (menu == 5) { // 도서등록

			} else if (menu == 6) { // 마이페이지

			} else if (menu == 9) {
				System.out.println("\t\t이용해주셔서 감사합니다.");
				System.out.println();
				service.sateTofile();
				break;
			}

		} // while 끝
		System.out.println("End");

	}

}
