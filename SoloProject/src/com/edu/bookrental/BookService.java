package com.edu.bookrental;

import java.util.List;

public interface BookService {
	
	public void join(User user); // 회원가입
	
	public int check(String id); // 중복체크
	
	public int logIn(String id, String pw); // 로그인

	public List<Book> bookList(Book book); // 도서전체목록
	
	public void summaryLook(Book book); // 도서상세보기
	
//	public Book searchTitle(String title); // 제목검색

//	public List<Book> searchCategory(String category); // 카테고리 검색

	public void rentBook(String title, String borrower); // 도서대여
	
//	public List<Book> possibleList(); // 대여가능한 목록

	public boolean returnBook(String title); // 도서반납
	
//	public List<Book> rentList(); // 대여한 목록

	public void insertBook(Book book); // 도서등록
	
//	public List<Book> insertList(); // 등록한도서목록

	public int checkPw(String pw);
	
	public void modifyPhone(String phone); // 회원정보수정
	
	public boolean modifyBook(String summary, String title); // 도서수정 

	public boolean removeBook(String title, int amount); // 도서삭제
	
	public void sateTofile();



}
