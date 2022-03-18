package com.edu;

public class Student { // class는 default 아니면 public
	// 학생번호, 학생이름, 국어점수, 수학점수, 영어점수 <= 필드정의
	private int studNo; // Student라는 클래스 밖에서는 접근 불가하도록 private으로 속성 설정
	private String studName;
	private int korScore = -1;;
	private int mathScore = -1;
	private int engScore = -1;

	// 생성자 : 필드의 값을 초기화 할 때 사용하므로 반환값이 없음
	Student() {
		this.studNo = 1;
		this.studName = "Nobody";
		this.korScore = 0;
		this.engScore = 0;
	}

	Student(int studNo) { // int타입의 매개변수 지정
		this.studNo = studNo;
	}

	public Student(int studNo, String studName) {
		this.studNo = studNo;
		this.studName = studName;
	}

	public Student(int studNo, String studName, int korScore, int mathScore, int engScore) {
		super();
		this.studNo = studNo;
		this.studName = studName;
		this.korScore = korScore;
		this.mathScore = mathScore;
		this.engScore = engScore;
	}
	
	// 메소드...
	public static void callStatic() {
		System.out.println("정적메소드 실행...");
	}
	// 영어, 국어, 수학 ==> 값이 저장되면 평균...
	public double getAvgScore() {
		return this.getSumScore() / 3.0; // getSumScore는 하나밖에 없어서 this 안써도 특정되니까 안써도 상관x
	}

	// 영어, 국어, 수학 ==> 합계점수
	int getSumScore() {
		if (this.korScore != -1 && this.engScore != -1 && this.mathScore != -1) {
			return this.korScore + this.engScore + this.mathScore;
		}
		return -1;
	}

	// 기능(method) => 반환값 메소드명 매개변수 { } 로 만들어야 하는 규칙을 가짐
	void setStudNo(int studNo) { // void = 디폴트 접근 지시 | setStudNo는 studNo의 값을 담고자하는 메소드 | int studNo는 매개변수
		this.studNo = studNo; //
	}

	public int getStudNo() { // get은 값을 읽어올때 | int로 읽어오기만하면 되므로 매개변수 입력할 필요 x
		return this.studNo;
	}

	public String getStudName() { // public = 퍼블릭 접근 지시
		return studName;
	}

	public void setStudName(String studName) {
		this.studName = studName;
	}

	public int getKorScore() {
		return korScore;
	}

	public void setKorScore(int korScore) {
		this.korScore = korScore;
	}

	public int getMathScore() {
		return mathScore;
	}

	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}

	public int getEngScore() {
		return engScore;
	}

	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}
	
	public String getStudInfo() {
		String str = "\n------------------------------------";
		str += "\n 학생이름: " + this.getStudName(); // \n : 줄바꿈
		str += "\n 학번: " + this.getStudNo();
		str += "\n 평균: " + String.format("%.2f", this.getAvgScore());
		str += "\n------------------------------------\n";
		return str;
	}

}
