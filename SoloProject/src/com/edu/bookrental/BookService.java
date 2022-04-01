package com.edu.bookrental;

import java.util.List;

public interface BookService {
	
	public void join(User user); // 회원가입
	
	public int check(String id); // 중복체크
	
	public int logIn(String id, String pw); // 로그인

	public List<Book> bookList(); // 도서전체목록

	public List<Book> getBook(String category, String title); // 도서검색

	public void rentBook(int amount, String title, String borrower); // 도서대여

	public void returnBook(int amount, String title); // 도서반납

	public void insertBook(Book book); // 도서등록

	public void modifyPw(String pw); // 회원정보수정
	
	public void midifyBook(String title); // 도서수정 

	public void removeBook(String title); // 도서삭제

	public void sateTofile();

}
