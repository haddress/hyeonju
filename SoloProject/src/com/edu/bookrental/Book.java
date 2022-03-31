package com.edu.bookrental;

public class Book {

	// 필드 ------
	private String ISBN;
	private String category;
	private String title;
	private String writer;
	private String bookCompany;
	private int amount;
	private String rentO;
	// ----------

	// 기본생성자 ---
	public Book() {

	}
	// ----------

	// 생성자 -----
	public Book(String iSBN, String category, String title, String writer, String bookCompany, int amount,
			String rentO) {
		super();
		ISBN = iSBN;
		this.category = category;
		this.title = title;
		this.writer = writer;
		this.bookCompany = bookCompany;
		this.amount = amount;
		this.rentO = rentO;
	}
	// ----------

	// 겟셋메소드 --
	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getBookCompany() {
		return bookCompany;
	}

	public void setBookCompany(String bookCompany) {
		this.bookCompany = bookCompany;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getRentO() {
		return rentO;
	}

	public void setRentO(String rentO) {
		this.rentO = rentO;
	}

	// ----------

	// toString()
	@Override
	public String toString() {
		return "[ISBN=" + ISBN + ", category=" + category + ", title=" + title + ", writer=" + writer
				+ ", bookCompany=" + bookCompany + ", amount=" + amount + ", rentO=" + rentO + "]";
	}
}
