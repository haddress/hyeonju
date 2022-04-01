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
	private String uploader;
	private String summary;
	private String borrower;
	// ----------

	// 기본생성자 ---
	public Book() {

	}
	// ----------

	// 생성자 -----
	public Book(String iSBN, String category, String title, String writer, String bookCompany, int amount, String rentO,
			String uploader, String summary, String borrower) {
		super();
		ISBN = iSBN;
		this.category = category;
		this.title = title;
		this.writer = writer;
		this.bookCompany = bookCompany;
		this.amount = amount;
		this.rentO = rentO;
		this.uploader = uploader;
		this.summary = summary;
		this.borrower = borrower;
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
	public String getUploader() {
		return uploader;
	}

	public void setUploader(String uploader) {
		this.uploader = uploader;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getBorrower() {
		return borrower;
	}

	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}


	// ----------
	

	// toString()
	@Override
	public String toString() {
		
		if (amount>0) {
			rentO = "대여가능";
		} else {
			rentO = "대여불가";
		}
		
		return "\t"+"-------------------------------------------------------------\n"
				+ "\tISBN:  " + ISBN + "\n"
				+ "\t카테고리:  " + category + "\n"
				+ "\t도서명:  " + title + "\n"
				+ "\t저자:  " + writer + "\n"
				+ "\t출판사:  " + bookCompany + "\n"
				+ "\t보유수량:  " + amount + "\n"
				+ "\t"+"[" + rentO + "]"+ "\n"
				+ "\t-------------------------------------------------------------\n";
		
	}
	
	public String toSummary() {
		return "\t"+"-------------------------------------------------------------\n"
				+ "\t" + category + " | " + title + " | " + writer + " | " + bookCompany +"\n"
				+ "책 소개: " + "\n"
				+ summary + "\n"
				+ "\t-------------------------------------------------------------\n";
		
	}
	
}
