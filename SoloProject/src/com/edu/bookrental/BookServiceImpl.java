package com.edu.bookrental;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl extends DAO implements BookService {

	@Override
	public void join(User user) { // 회원가입
		conn = getConnect();
		String sql = "INSERT INTO app_member (id, pw) " + "VALUES (?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user.getId());
			psmt.setString(2, user.getPw());
			psmt.executeUpdate();
			System.out.println("회원가입을 축하드립니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

	@Override
	public void acout(String pw) { // 회원탈퇴
		conn = getConnect();
		String sql = "DELETE FROM app_member " + "WHERE pw = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pw);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	@Override
	public int check(String id) { // 아이디 검색
		conn = getConnect();
		String sql = "SELECT*FROM app_member\r\n" + "WHERE id = ?";
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
	public List<Book> bookList(Book bk) { // 도서전체목록
		List<Book> bookList = new ArrayList<Book>();
		conn = getConnect();
		int cnt = 1;
		String sql = "SELECT * FROM book_list ";
		sql += "WHERE 1=1";
		if (bk.getAmount() > 0) {
			sql += "and amount > 0";
		}
		if (bk.getUploader() != null) {
			sql += "and uploader = nvl(?, uploader)";
		}
		if (bk.getCategory() != null) {
			sql += "and category = nvl(?, category)";
		}
		if (bk.getTitle() != null) {
			sql += "and title like '%'||nvl(?, '')||'%'";
		}
		if (bk.getBorrower() != null) {
			sql += "and borrower = nvl(?, borrower)";
		}

		sql += "ORDER BY isbn";
		try {
			psmt = conn.prepareStatement(sql);
			if (bk.getUploader() != null) {
				psmt.setString(cnt++, bk.getUploader());
			}
			if (bk.getCategory() != null) {
				psmt.setString(cnt++, bk.getCategory());
			}
			if (bk.getTitle() != null) {
				psmt.setString(cnt++, bk.getTitle());
			}
			if (bk.getBorrower() != null) {
				psmt.setString(cnt++, bk.getBorrower());
			}

			rs = psmt.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				book.setISBN(rs.getInt("isbn"));
				book.setCategory(rs.getString("category"));
				book.setTitle(rs.getString("title"));
				book.setWriter(rs.getString("writer"));
				book.setBookCompany(rs.getString("book_company"));
				book.setAmount(rs.getInt("amount"));
				book.setUploader(rs.getString("uploader"));
				book.setSummary(rs.getString("summary"));

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
	public void rentBook(String title, String borrower) { // 도서대여
		conn = getConnect();

		String sql = "update book_list\r\n" + "set amount =amount-1, borrower = ? " + "where title = ?";
		try {
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, borrower);
			psmt.setString(2, title);

			psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	@Override
	public boolean returnBook(String title, int amount) { // 도서반납
		conn = getConnect();

		String sql = "UPDATE book_list " + "SET amount = amount+1, borrower=null "
				+ "WHERE isbn = (SELECT b.isbn FROM book_list b join app_member a on (b.borrower = a.id) WHERE title = ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, title);

			int r = psmt.executeUpdate();

			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;

	}

	@Override
	public void insertBook(Book book) { // 도서등록
		conn = getConnect();
		String sql = "INSERT INTO book_list (isbn, category, title, writer, book_company, amount, uploader, summary) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, book.getISBN());
			psmt.setString(2, book.getCategory());
			psmt.setString(3, book.getTitle());
			psmt.setString(4, book.getWriter());
			psmt.setString(5, book.getBookCompany());
			psmt.setInt(6, book.getAmount());
			psmt.setString(7, loginId);
			psmt.setString(8, book.getSummary());
			int r = psmt.executeUpdate();
			System.out.println(r + "건의 도서가 등록되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

	@Override
	public int checkPw(String pw) { // 비밀번호 검색
		conn = getConnect();
		String sql = "SELECT * FROM app_member " + "WHERE id = ? " + "AND pw = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, loginId);
			psmt.setString(2, pw);
			rs = psmt.executeQuery();

			if (rs.next()) {
				return 1;
			} else {
				System.out.println("비밀번호가 일치하지 않습니다.");
				System.out.println();
				return -1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return -2;
	}

	@Override
	public void modifyPhone(String phone) { // 회원정보수정
		conn = getConnect();
		String sql = "UPDATE app_member " + "SET phone = ? " + "WHERE id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, phone);
			psmt.setString(2, loginId);

			psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

	@Override
	public boolean modifyBook(String summary, String title) { // 도서수정
		conn = getConnect();
		String sql = "UPDATE book_list " + "SET summary = ? "
				+ "WHERE isbn = (SELECT b.isbn FROM book_list b JOIN app_member a on (b.uploader = a.id) WHERE title = ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, summary);
			psmt.setString(2, title);

			int r = psmt.executeUpdate();

			if (r > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}

	@Override
	public boolean removeBook(String title, int amount) { // 도서삭제
		conn = getConnect();
		if (amount > 0) {
			String sql = "UPDATE book_list " + "SET amount = amount-1 "
					+ "WHERE isbn = (SELECT b.isbn FROM book_list b join app_member a on (b.uploader = a.id) WHERE title = ?)";
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, title);

				int r = psmt.executeUpdate();

				if (r > 0) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconnect();
			}
			return false;
		} else if (amount <= 0) {
			String sql = "DELETE FROM book_list "
					+ "WHERE isbn = (SELECT b.isbn FROM book_list b JOIN app_member a on (b.uploader = a.id) WHERE title = ?)";
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, title);

				int r = psmt.executeUpdate();

				if (r > 0) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconnect();
			}
			return false;
		}
		return false;

	}

	@Override
	public void sateTofile() { // 저장

	}

}
