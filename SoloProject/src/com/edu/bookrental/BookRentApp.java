package com.edu.bookrental;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookRentApp extends DAO {

	// 도서컬렉션 필드
	List<Book> books = new ArrayList<Book>();

	Scanner scn = new Scanner(System.in);

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

					User user = new User(id, pw, null);
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
				Book book = new Book();
				List<Book> bookList = service.bookList(book);
				System.out.println("도서가 조회되었습니다." + "\n");
				for (Book b : bookList) {
					System.out.println(b.toString());
				}

			} else if (menu == 2) { // 검색
				System.out.println("");
				System.out.println("\t-------------------------------------------------------------");
				System.out.println("\t\t[   (1)도서명으로 검색      |     (2)카테고리별로 검색   ]");
				System.out.print("\t선택>> ");
				int menu2 = scn.nextInt();
				System.out.println();
				if (menu2 == 1) { // 도서명검색
					System.out.print("\t[검색] 도서명>> ");
					String title = scn.nextLine();
					title = scn.nextLine();
					System.out.println();
					Book book = new Book();
					book.setTitle(title);
					List<Book> bookList = service.bookList(book);
					if (bookList.isEmpty()) {
						System.out.println("조회된 결과가 없습니다.");
					} else {
						System.out.println("도서가 검색되었습니다." + "\n");
						System.out.println(book.toString());

					}
				} else if (menu2 == 2) {
					System.out.print("\t[검색] 카테고리명>> ");
					String category = scn.next();
					System.out.println();
					Book book = new Book();
					book.setCategory(category);
					List<Book> bookList = service.bookList(book);
					if (bookList.isEmpty()) {
						System.out.println("조회된 결과가 없습니다.");
					} else {
						System.out.println("도서가 검색되었습니다." + "\n");
						for (Book b : bookList) {
							System.out.println(b.toString());
						}
					}
				}

			} else if (menu == 3) { // 대여 // 수정필요!!!!!! 수량0인 도서가 뜸
				System.out.println("\t[대여가능한 도서 목록]" + "\r");
				Book book = new Book();
				int amount = book.getAmount();
				book.setAmount(amount);
				List<Book> bookList = service.bookList(book);
				for (Book b : bookList) {
					System.out.println(b.toRent());
				}
				while (true) {
					System.out.println();
					System.out.println("\t대여하실 도서명을 입력하세요.");
					System.out.print("\t>> ");
					String title = scn.nextLine();
					title = scn.nextLine();
					System.out.println();
					book.setTitle(title);
					bookList = service.bookList(book); // 체크
					if (bookList.isEmpty()) {
						System.out.println("조회된 결과가 없습니다.");
						continue;
					} else {
						if (book.getAmount() > 0) {
							System.out.println("도서가 검색되었습니다." + "\n");
							System.out.println(book.toString()); // 체크
							String borrower = null;
							service.rentBook(title, borrower);
							System.out.println("\t대여하시겠습니까?");
							System.out.println("\t①[예] | ②[아니오]");
							System.out.print("\t>> ");
							int selec = scn.nextInt();
							System.out.println();
							if (selec == 1) {
								borrower = loginId;
								service.rentBook(title, borrower);
								System.out.println("대여가 완료되었습니다.");
								break;
							} else if (selec == 2) {
								break;
							}
						} else if (book.getAmount() <= 0) {
							System.out.println("대여가 불가합니다.");
							break;
						}
					}
				}

			} else if (menu == 4) { // 반납
				System.out.println("\t[반납가능한 도서 목록]" + "\r");
				Book book = new Book();
				book.setBorrower(loginId);
				List<Book> bookList = service.bookList(book);
				for (Book b : bookList) {
					System.out.println(b.toReturn());
				}
				System.out.println();
				System.out.println("\t반납하실 도서명을 입력하세요.");
				System.out.print("\t>> ");
				String title = scn.nextLine();
				title = scn.nextLine();
				System.out.println();
				book.setTitle(title);
				bookList = service.bookList(book); // 체크
				if (bookList.isEmpty()) {
					System.out.println("조회된 결과가 없습니다.");
				} else {
					System.out.println("도서가 검색되었습니다." + "\n");

					System.out.println(book.toString()); // 체크

					System.out.println("\t반납하시겠습니까?");
					System.out.println("\t①[예] | ②[아니오]");
					System.out.print("\t>> ");
					int selec = scn.nextInt();
					System.out.println();
					if (selec == 1) {
						boolean tOrf = service.returnBook(title);
						if (tOrf) {
							System.out.println("도서를 반납하였습니다.");
							System.out.println();
						} else {
							System.out.println("반납 권한이 없습니다.");
						}
					} else if (selec == 2) {
						continue;
					}
				}

			} else if (menu == 5) { // 도서등록
				System.out.println("\t-------------------------------------------------------------" + "\n");
				System.out.print("\t등록할 도서의 제목>> ");
				String title = scn.nextLine();
				title = scn.nextLine();
				System.out.print("\t저자>> ");
				String writer = scn.next();
				System.out.print("\tISBN>> ");
				String ISBN = scn.next();
				System.out.println("\t카테고리");
				System.out.println("\t[   소설   |   에세이   |   인문  ]");
				System.out.print("\t>> ");
				String category = scn.next();
				System.out.print("\t출판사>> ");
				String bookCompany = scn.nextLine();
				bookCompany = scn.nextLine();
				System.out.println("\t도서소개");
				System.out.print("\t>> ");
				String summary = scn.nextLine();
				System.out.print("\t수량>> ");
				int amount = scn.nextInt();
				String uploader = loginId;
				String borrower = null;

				Book book = new Book(ISBN, category, title, writer, bookCompany, amount, uploader, summary, borrower);
				service.insertBook(book);

			} else if (menu == 6) { // 마이페이지 -> 회원정보수정, 등록한 도서관리(목록,수정,삭제)
				System.out.println("\t-------------------------------------------------------------");
				System.out.println("\t\t\t\t   [MY PAGE]    " + "\n");
				System.out.println("\t\t[    (1)휴대폰 번호 수정    |      (2)도서관리     ]");
				System.out.print("\t선택>> ");
				int mypage = scn.nextInt();
				System.out.println();
				if (mypage == 1) {
					while (true) {
						System.out.println("\t비밀번호를 입력하세요.");
						System.out.print("\t>> ");
						String pw = scn.next();
						int checkPw = service.checkPw(pw);
						if (checkPw == 1) {
							System.out.println("\t변경하실 휴대폰 번호를 입력하세요.");
							System.out.print("\t>> ");
							String phone = scn.next();

							User user = new User();

							user.setPhone(phone);

							service.modifyPhone(phone);
							System.out.println("회원정보를 수정하였습니다.");
							System.out.println();
							break;
						} else if (checkPw == 2) {
							continue;
						}
					}
				} else if (mypage == 2) {
					System.out.println("\t    [   (1)등록도서목록   |   (2)도서정보수정   |    (3)도서삭제    ]");
					System.out.print("\t선택>> ");
					int admin = scn.nextInt();
					System.out.println();
					if (admin == 1) {
						Book book = new Book();
						book.setUploader(loginId);
						List<Book> bookList = service.bookList(book);
						for (Book b : bookList) {
							System.out.println(b.toReturn());
						}
					} else if (admin == 2) {
						System.out.println("\t[수정가능한 도서 목록]" + "\r");
//						List<Book> bookList = service.insertList();
						Book book = new Book();
						book.setUploader(loginId);
						List<Book> bookList = service.bookList(book);
						for (Book b : bookList) {
							System.out.println(b.toReturn());
						}
						System.out.println("\t변경할 도서명을 입력하세요.");
						System.out.print("\t>> ");
						String title = scn.next();
						System.out.println();

						System.out.println("\t도서 내용을 수정하세요.");
						System.out.print("\t>> ");
						String summary = scn.nextLine();
						summary = scn.nextLine();
						
						boolean tOrf = service.modifyBook(summary, title);
						if (tOrf) {
							book = new Book();
							book.setSummary(summary);
							
							System.out.println("도서 수정이 완료되었습니다.");
						} else {
							System.out.println("수정 권한이 없습니다.");
						}

					} else if (admin == 3) {
						System.out.println("\t삭제할 도서명을 입력하세요.");
						System.out.print("\t>> ");
						String title = scn.nextLine();
						title = scn.nextLine();

						boolean tOrf = service.removeBook(title, 0);
						if (tOrf) {
							System.out.println("도서를 삭제하였습니다.");
						} else {
							System.out.println("삭제 권한이 없습니다.");
						}

					}
				}
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
