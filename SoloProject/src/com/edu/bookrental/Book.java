package com.edu.bookrental;

public class Book {

	// 필드 ------
	private int ISBN;
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
	public Book(int iSBN, String category, String title, String writer, String bookCompany, int amount, 
			String uploader, String summary, String borrower) {
		super();
		ISBN = iSBN;
		this.category = category;
		this.title = title;
		this.writer = writer;
		this.bookCompany = bookCompany;
		this.amount = amount;
		this.uploader = uploader;
		this.summary = summary;
		this.borrower = borrower;
	}
	// ----------

	// 겟셋메소드 --
	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
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
		
		return String.format("\t%-5d%-8s%-20s%-12s%-2s\n", ISBN, category, title, writer, bookCompany);
		
	}
	
	public String toRent() {
		if (amount>0) {
			rentO = "대여가능";
		} else {
			rentO = "대여불가";
		}
		
		return String.format("\t%-5d%-8s%-18s%-10s%-10s%-2s%-8s\n", ISBN, category, title, writer, bookCompany, amount, rentO);
		
	}
	
	public String toReturn() {
		
		return String.format("\t%-5d%-10s%-20s%-12s%-12s\n", ISBN, category, title, writer, bookCompany);
		
	}
	
	public String toSummary() {
		return String.format("\t%-12s%-24s%-14s%-16s\n\n\t%-150s\n", category, title, writer, bookCompany, summary);
		
	}
	

	
}
