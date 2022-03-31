package com.edu.bookrental;

import java.util.List;

public interface BookService {

	public int logIn(String id, String pw); // 로그인

	public List<Book> bookList(); // 도서전체목록

	public List<Book> getBook(String title); // 도서검색

	public List<Book> rentBook(String title); // 도서대여

	public void returnBook(String title); // 도서반납

	public void insertBook(Book book); // 도서등록

	public void modifyPw(String pw); // 회원정보수정

	public void removeBook(String title); // 도서삭제

	public void sateTofile();

}
