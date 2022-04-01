package com.edu.bookrental;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl extends DAO implements BookService {
	
	@Override
	public void join(User user) { // 회원가입
		conn = getConnect();
		String sql = "INSERT INTO app_member (id, pw) "
				+ "VALUES (?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user.getId());
			psmt.setString(2, user.getPw());
			int r = psmt.executeUpdate();
			System.out.println("회원가입을 축하드립니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
	}
	
	@Override
	public int check(String id) { // 아이디 검색
		conn = getConnect();
		String sql = "SELECT*FROM app_member\r\n"
				+ "WHERE id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				System.out.println("이미 존재하는 아이디입니다.");
				return 0;
			} else {
				System.out.println("아이디를 사용하실 수 있습니다.");
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return -2;
		
	}

	@Override
	public int logIn(String id, String pw) { // 로그인 기능
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
		String sql = "SELECT * FROM book_list " + "ORDER BY isbn";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				book.setISBN(rs.getString("isbn"));
				book.setCategory(rs.getString("category"));
				book.setTitle(rs.getString("title"));
				book.setWriter(rs.getString("writer"));
				book.setBookCompany(rs.getString("book_company"));
				book.setAmount(rs.getInt("amount"));
				book.setUploader(rs.getString("uploader"));

				bookList.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return bookList;
	}

	@Override
	public List<Book> getBook(String category, String title) { // 도서검색
		List<Book> searchList = new ArrayList<Book>();

		conn = getConnect();
		Book book = null;
		String sql = "SELECT*FROM book_list ";
		sql += "WHERE 1=1 ";
		if (title != null)
			sql += " and title = ?";
		if (category != null)
			sql += " and category = ?";
		int cnt = 0;
		try {
			psmt = conn.prepareStatement(sql);

			if (title != null)
				psmt.setString(++cnt, title);

			if (category != null)
				psmt.setString(++cnt, category);

			rs = psmt.executeQuery();
			while (rs.next()) {
				book = new Book();
				book.setISBN(rs.getString("isbn"));
				book.setCategory(rs.getString("category"));
				book.setTitle(rs.getString("title"));
				book.setWriter(rs.getString("writer"));
				book.setBookCompany(rs.getString("book_company"));
				book.setAmount(rs.getInt("amount"));
				book.setUploader(rs.getString("uploader"));

				searchList.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return searchList;
	}

	@Override
	public void rentBook(int amount, String title, String borrower) { // 도서대여
		conn = getConnect();
		String sql = "update book_list\r\n"
				+ "set amount =amount-1, borrower = ? "
				+ "where title = ?";
		try {
			psmt = conn.prepareStatement(sql);
			while (true) {
				if (amount >= 1) {
					psmt.setString(1, borrower);
					psmt.setString(2, title);

					int r = psmt.executeUpdate();
					System.out.println(r + "건의 도서를 대여하였습니다.");
					break;
				} else {
					System.out.println("대여가 불가합니다.");
					continue;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

	@Override
	public void returnBook(int amount, String title) { // 도서반납
		conn = getConnect();
		String sql = "update book_list "
				+ "set amount =amount+1, borrower=null "
				+ "where title = ?";
		try {
			psmt = conn.prepareStatement(sql);

			if (amount < 1) {
				psmt.setString(1, title);
				
				int r = psmt.executeUpdate();
				System.out.println(r + "건의 도서를 반납하였습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

	@Override
	public void insertBook(Book book) { // 도서등록

	}

	@Override
	public void modifyPw(String pw) { // 회원정보수정

	}

	@Override
	public void midifyBook(String title) { // 도서수정

	}

	@Override
	public void removeBook(String title) { // 도서삭제

	}

	@Override
	public void sateTofile() { // 저장

	}

	



}
