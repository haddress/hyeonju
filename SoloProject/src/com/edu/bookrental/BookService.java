package com.edu.bookrental;

import java.util.List;

public interface BookService {
	
	public void join(User user); // 회원가입
	
	public int check(String id); // 중복체크
	
	public int logIn(String id, String pw); // 로그인

	public List<Book> bookList(); // 도서전체목록

	public List<Book> getBook(String category, String title); // 도서검색

	public void rentBook(int amount, String title, String borrower); // 도서대여
	
	public List<Book> possibleList(); // 대여가능한 목록

	public void returnBook(int amount, String title); // 도서반납
	
	public List<Book> rentList(); // 대여한 목록

	public void insertBook(Book book); // 도서등록
	
	public List<Book> insertList(); // 등록한도서목록

	public void modifyPhone(User user); // 회원정보수정
	
	public void modifyBook(Book book); // 도서수정 

	public void removeBook(String title, int amount); // 도서삭제
	
	public void sateTofile();



}
