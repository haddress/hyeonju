package com.prod;

public class BookExample {
	
	public static void main(String[] args) {
		// 책(책제목, 저자, 출판사, 가격)
		
		// book1=> 초기화 : 혼공자, 신용권, 한빛미디어, 24000
		// book2=> 초기화 : powerJava, 전인국, 인피니티, 35000
		// book3=> 초기화 : 재밌는 Java, 이호준, 인피니티, 20000
		Book b1 = new Book();
		b1.bookTitle = "혼공자";
		b1.bookWriter = "신용권";
		b1.bookCompany = "한빛미디어";
		b1.price = 24000;
		
		Book b2 = new Book();
		b2.bookTitle = "powerJava";
		b2.bookWriter = "전인국";
		b2.bookCompany = "인피니티";
		b2.price = 35000;
		
		Book b3 = new Book();
		b3.bookTitle = "재밌는 Java";
		b3.bookWriter = "이호준";
		b3.bookCompany = "인피니티";
		b3.price = 20000;
		
		Book[] books = { b1, b2, b3 };
		
		for (int i = 0; i<books.length; i++) {
			if(books[i].bookCompany == "인피니티") {
				System.out.println("==================================");
				System.out.println("책 제목: " + books[i].bookTitle);
				System.out.println("책 저자: " + books[i].bookWriter);
				System.out.println("출판사: " + books[i].bookCompany);
				System.out.println("가격: " + books[i].price);
				System.out.println("==================================");
			}
			
			if(books[i].bookWriter == "신용권") {
				System.out.println("==================================");
				System.out.println("책 제목: " + books[i].bookTitle);
				System.out.println("==================================");
			}
		}
		
		
	}

}
