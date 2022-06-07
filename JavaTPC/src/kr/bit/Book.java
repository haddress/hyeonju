package kr.bit;
// 현실세계의 책을 객체지향 프로그램에서 사용하기 위해 설계
// 책-> 제목, 가격, 출판사, 페이지 수... (= 상태정보)
// 모든 객체는 상태정보+행위정보(동적->메소드)가 합쳐진 것
public class Book { // 사용자 정의 자료형 -> 클래스라는 도구로 책이라는 자료형을 book이라는 자료형 이름으로 만듦(모델링)
	
	// 이 클래스는 book이라고 정의했지만, 일반적으로는 BookVO라고 정의
	// VO(Value Object) -> 데이터를 저장하기 위해 하나의 구조로 만들어놓은 객체
	// 또는 DTO(Data Transfer Object) -> 데이터를 이동할 수 있는 객체
	
	// 사용자정의자료형(UDDT)
	// class -> 새로운 자료형을 만드는 도구(Modeling 도구)
	// 공간 여러개를 하나의 구조로 붙여놓은 덩어리 = 객체
	// 객체를 설계하기 위해 클래스라는 도구를 이용
	
	public String title;
	public int price;
	public String company;
	public int page;
	
}
