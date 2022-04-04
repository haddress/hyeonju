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
	public Book getTitle(String title) { // 제목검색
		conn = getConnect();
		Book book = null;
		String sql = "SELECT * FROM book_list " + "WHERE title = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, title);

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
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return book;
	}
	

	@Override
	public List<Book> getCategory(String category) { // 카테고리검색
		List<Book> searchCate = new ArrayList<Book>();

		conn = getConnect();
		
		String sql = "SELECT * FROM book_list " + "WHERE category = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, category);

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

				searchCate.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return searchCate;
	}

//	@Override
//	public List<Book> getBook(String category, String title) { // 
//		List<Book> searchList = new ArrayList<Book>();
//
//		conn = getConnect();
//		Book book = null;
//		String sql = "SELECT*FROM book_list ";
//		sql += "WHERE 1=1 ";
//		if (title != null)
//			sql += " and title = ?";
//		if (category != null)
//			sql += " and category = ?";
//		int cnt = 0;
//		try {
//			psmt = conn.prepareStatement(sql);
//
//			if (title != null)
//				psmt.setString(++cnt, title);
//
//			if (category != null)
//				psmt.setString(++cnt, category);
//
//			rs = psmt.executeQuery();
//			while (rs.next()) {
//				book = new Book();
//				book.setISBN(rs.getString("isbn"));
//				book.setCategory(rs.getString("category"));
//				book.setTitle(rs.getString("title"));
//				book.setWriter(rs.getString("writer"));
//				book.setBookCompany(rs.getString("book_company"));
//				book.setAmount(rs.getInt("amount"));
//				book.setUploader(rs.getString("uploader"));
//
//				searchList.add(book);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			disconnect();
//		}
//		return searchList;
//	}

	@Override
	public void rentBook(int amount, String title, String borrower) { // 도서대여
		conn = getConnect();
		String sql = "update book_list\r\n" + "set amount =amount-1, borrower = ? " + "where title = ?";
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
	public List<Book> possibleList() { // 대여가능한 목록
		List<Book> bookList = new ArrayList<Book>();
		conn = getConnect();
		String sql = "SELECT * FROM book_list " + "WHERE amount > 0 " + "ORDER BY isbn";
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
	public boolean returnBook(String title) { // 도서반납
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
	public List<Book> rentList() { // 대여한 목록
		List<Book> bookList = new ArrayList<Book>();
		conn = getConnect();
		String sql = "SELECT * FROM book_list " + "WHERE borrower = ? " + "ORDER BY isbn";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, loginId);
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
	public void insertBook(Book book) { // 도서등록
		conn = getConnect();
		String sql = "INSERT INTO book_list (isbn, category, title, writer, book_company, amount, uploader, summary) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, book.getISBN());
			psmt.setString(2, book.getCategory());
			psmt.setString(3, book.getTitle());
			psmt.setString(4, book.getWriter());
			psmt.setString(5, book.getBookCompany());
			psmt.setInt(6, book.getAmount());
			psmt.setString(7, book.getBorrower());
			psmt.setString(8, book.getSummary());
			int r = psmt.executeUpdate();
			System.out.println(r + "건의 도서를 등록하였습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

	@Override
	public List<Book> insertList() { // 등록한 도서 목록
		List<Book> bookList = new ArrayList<Book>();
		conn = getConnect();
		String sql = "SELECT * FROM book_list " + "WHERE uploader = ? " + "ORDER BY isbn";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, loginId);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				book.setISBN(rs.getString("isbn"));
				book.setCategory(rs.getString("category"));
				book.setTitle(rs.getString("title"));
				book.setWriter(rs.getString("writer"));
				book.setBookCompany(rs.getString("book_company"));
				book.setAmount(rs.getInt("amount"));
				book.setUploader(loginId);

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
	public void modifyPhone(User user) { // 회원정보수정 !! 수정
		conn = getConnect();
		String sql = "UPDATE app_member " + "SET phone=? " + "WHERE id=?";
		try {
			psmt = conn.prepareStatement(sql);
			while (true) {
				if (rs.getString("id").equals(loginId)) {
					psmt.setString(1, user.getPhone());
					psmt.setString(2, loginId);

					int r = psmt.executeUpdate();
					System.out.println(r + "건의 회원정보를 수정했습니다.");
					break;
				} else {
					System.out.println("정보 수정의 권한이 없습니다.");
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
	public void modifyBook(Book book) { // 도서수정 !! 수정
		conn = getConnect();
		String sql = "UPDATE book_list " + "SET summary=? " + "WHERE title=?";
		try {
			psmt = conn.prepareStatement(sql);
			while (true) {
				if (rs.getString("uploader").equals(loginId)) {
					psmt.setString(1, book.getSummary());
					psmt.setString(2, book.getTitle());

					int r = psmt.executeUpdate();
					System.out.println(r + "건의 도서정보를 수정했습니다.");
					break;
				} else {
					System.out.println("정보 수정의 권한이 없습니다.");
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
	public void removeBook(String title, int amount, String loginId) { // 도서삭제 !! 수정
		conn = getConnect();
		if (amount > 0) {
			String sql = "UPDATE book_list " + "set amount=amount-1 " + "WHERE title = ?";
			try {
				psmt = conn.prepareStatement(sql);
				while (true) {
					if (rs.getString("uploader").equals(loginId)) {
						psmt.setString(1, title);

						int r = psmt.executeUpdate();
						System.out.println(r + "건의 도서가 삭제되었습니다.");
						break;
					} else {
						System.out.println("도서 삭제의 권한이 없습니다.");
						continue;
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconnect();
			}
		} else if (amount <= 0) {
			String sql = "DELETE FROM book_list " + "WHERE title = ?";
			try {
				psmt = conn.prepareStatement(sql);
				while (true) {
					if (rs.getString("uploader").equals(loginId)) {
						psmt.setString(1, title);

						int r = psmt.executeUpdate();
						System.out.println(r + "건의 도서가 삭제되었습니다.");
						break;
					} else {
						System.out.println("도서 삭제의 권한이 없습니다.");
						continue;
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconnect();
			}
		}
	}

	@Override
	public void sateTofile() { // 저장

	}

}
