package com.edu.bookrental;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl extends DAO implements BookService {

	@Override
	public int logIn(String id, String pw) {
		conn = getConnect();
		String sql = "SELECT * FROM app_member " + "WHERE id = ? " + "AND pw = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			rs = psmt.executeQuery();
			if (rs.next()) {
				return 1; // 로그인성공
			}
			return -1; // 아이디없음
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return -2; // db오류
	}

	@Override
	public List<Book> bookList() { // 도서전체목록
		List<Book> bookList = new ArrayList<Book>();
		conn = getConnect();
		String sql = "SELECT * FROM book_list "
				+ "ORDER BY isbn";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return bookList;
	}

	@Override
	public List<Book> getBook(String title) { // 도서검색
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> rentBook(String title) { // 도서대여
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void returnBook(String title) { // 도서반납
		// TODO Auto-generated method stub

	}

	@Override
	public void insertBook(Book book) { // 도서등록
		// TODO Auto-generated method stub

	}

	@Override
	public void modifyPw(String pw) { // 회원정보수정
		// TODO Auto-generated method stub

	}

	@Override
	public void removeBook(String title) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sateTofile() { // 도서삭제
		// TODO Auto-generated method stub

	}

}
