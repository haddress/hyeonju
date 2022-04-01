package com.edu.bookrental;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookRentApp {

	// 도서컬렉션 필드
	List<Book> books = new ArrayList<Book>();

	Scanner scn = new Scanner(System.in);

	static String loginId;

	BookServiceImpl impl = new BookServiceImpl();

	// 내부클래스

	// execute() : 앱 실행하는 메인메소드
	public void execute() {
		BookService service = new BookServiceImpl();

		System.out.println("로그인이 필요합니다.\n");
		System.out.println("\t-------------------------------------------------------------");
		System.out.println("\t\t    [1. 회원가입]         |         [2. 로그인]    ");
		System.out.print("\t>> ");
		int log = scn.nextInt();
		if (log == 1) {
			while (true) {
				System.out.println();
				System.out.println("\t-------------------------------------------------------------");
				System.out.println("\t사용하실 아이디를 입력하세요.");
				System.out.print("\t>> ");
				String id = scn.next();
				int tOrf = impl.check(id);
				if (tOrf == 0) {
					continue;
				} else if (tOrf == 1) {
					System.out.println();
					System.out.println("\t-------------------------------------------------------------");
					System.out.println("\t사용하실 비밀번호를 입력하세요.");
					System.out.print("\t>> ");
					String pw = scn.next();

					User user = new User(id, pw);
					service.join(user);
					break;
				}

			}
		} else if (log == 2) {
			while (true) {
				System.out.println();
				System.out.println("\t-------------------------------------------------------------");
				System.out.print("\tID: ");
				String id = scn.next();
				System.out.print("\tPW: ");
				String pw = scn.next();
				System.out.println("\t-------------------------------------------------------------");

				int result = service.logIn(id, pw);
				if (result == 1) {
					System.out.println("\t로그인에 성공하였습니다!");
					loginId = id;
					System.out.println();
					break;
				} else if (result == 0) {
					System.out.println("\t비밀번호가 일치하지 않습니다.");
					System.out.println();
				} else if (result == -1) {
					System.out.println("\t존재하지 않는 아이디입니다.");
					System.out.println();
				} else if (result == -2) {
					System.out.println("\tDB 오류");
					System.out.println();
				}
			}

		}

		// 어플 첫 화면-----------------------------------
		while (true) {
			System.out.println("");
			System.out.println("\t-------------------------------------------------------------");
			System.out.println("\t1.도서목록 | 2.검색 | 3.대여 | 4.반납 | 5.도서등록 | 6.마이페이지 | 9.종료");
			System.out.print("\t선택>> ");

			// 메뉴입력----------------------------------
			int menu = scn.nextInt();
			System.out.println();
			if (menu == 1) { // 도서목록
				List<Book> bookList = service.bookList();
				System.out.println("도서가 조회되었습니다." + "\n");
				for (Book b : bookList) {
					System.out.println(b.toString());
				}

			} else if (menu == 2) { // 검색
				System.out.println("");
				System.out.println("\t-------------------------------------------------------------");
				System.out.println("\t\t(1)도서명으로 검색        |       (2)카테고리별로 검색");
				System.out.print("\t선택>> ");
				int menu2 = scn.nextInt();
				System.out.println();
				if (menu2 == 1) { // 도서명검색
					System.out.print("\t[검색] 도서명>> ");
					String title = scn.nextLine();
					title = scn.nextLine();
					System.out.println();
					List<Book> book = service.getBook(null, title);
					if (book == null) {
						System.out.println("조회된 결과가 없습니다.");
					} else {
						System.out.println("도서가 검색되었습니다." + "\n");
						for (Book b : book) {
							System.out.println(b.toString());
						}
					}
				} else if (menu2 == 2) {
					System.out.print("\t[검색] 카테고리명>> ");
					String category = scn.next();
					System.out.println();
					List<Book> book = service.getBook(category, null);
					if (book == null) {
						System.out.println("조회된 결과가 없습니다.");
					} else {
						System.out.println("도서가 검색되었습니다." + "\n");
						for (Book b : book) {
							System.out.println(b.toString());
						}
					}
				}

			} else if (menu == 3) { // 대여
				System.out.println("\t대여하실 도서를 검색하세요.");
				System.out.print("\t[검색] 도서명>> ");
				String title = scn.nextLine();
				title = scn.nextLine();
				System.out.println();
				List<Book> book = service.getBook(null, title);
				if (book == null) {
					System.out.println("조회된 결과가 없습니다.");
				} else {
					System.out.println("도서가 검색되었습니다." + "\n");
					for (Book b : book) {
						System.out.println(b.toString());
					}
					System.out.println("\t대여하시겠습니까?");
					System.out.println("\t①[예] | ②[아니오]");
					System.out.print("\t>> ");
					int selec = scn.nextInt();
					System.out.println();
					if (selec == 1) {
						String borrower = loginId;
						service.rentBook(selec, title, borrower);
						System.out.println("대여가 완료되었습니다.");
						System.out.println();
					} else if (selec == 2) {
						continue;
					}
				}

			} else if (menu == 4) { // 반납
				System.out.println("\t대여하실 도서를 검색하세요.");
				System.out.print("\t[검색] 도서명>> ");
				String title = scn.nextLine();
				title = scn.nextLine();
				System.out.println();
				List<Book> book = service.getBook(null, title);
				if (book == null) {
					System.out.println("조회된 결과가 없습니다.");
				} else {
					System.out.println("도서가 검색되었습니다." + "\n");
					for (Book b : book) {
						System.out.println(b.toString());
					}
					System.out.println("\t반납하시겠습니까?");
					System.out.println("\t①[예] | ②[아니오]");
					System.out.print("\t>> ");
					int selec = scn.nextInt();
					System.out.println();
					if (selec == 1) {
						service.returnBook(selec, title);
						System.out.println("반납이 완료되었습니다.");
						System.out.println();
					} else if (selec == 2) {
						continue;
					}
				}

			} else if (menu == 5) { // 도서등록

			} else if (menu == 6) { // 마이페이지

			} else if (menu == 9) {
				System.out.println("\t이용해주셔서 감사합니다.");
				System.out.println();
				service.sateTofile();
				break;
			}

		} // while 끝
		System.out.println("End");

	}

}
