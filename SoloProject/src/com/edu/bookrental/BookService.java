package com.edu.bookrental;

import java.util.List;

public interface BookService {

	public void join(User user); // 회원가입
	
	public void acout(String pw); // 회원탈퇴

	public int check(String id); // 중복체크

	public int logIn(String id, String pw); // 로그인

	public List<Book> bookList(Book book); // 도서전체목록

	public void rentBook(String title, String borrower); // 도서대여

	public boolean returnBook(String title, int amount); // 도서반납

	public void insertBook(Book book); // 도서등록

	public int checkPw(String pw); // 비밀번호 체크

	public void modifyPhone(String phone); // 회원정보수정

	public boolean modifyBook(String summary, String title); // 도서수정

	public boolean removeBook(String title, int amount); // 도서삭제

	public void sateTofile();

}
