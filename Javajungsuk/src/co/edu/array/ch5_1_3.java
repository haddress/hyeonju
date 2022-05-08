package co.edu.array;

public class ch5_1_3 {
	
	// 배열 : 같은 타입의 여러 변수를 하나의 묶음으로 다루는 것
		// 각 저장공간(요소)에 매번 이름을 붙이는 것은 번거로우므로 index를 통해 자동으로 번호를 부여.
		// index를 다루기 위해 참조변수가 필요하고, 이 참조변수에 이름을 붙임 ex) int[] score -> score가 참조변수

		// 배열을 선언한다는 것은 배열을 다루기 위한 참조변수를 선언하는 것
		// 타입[] 변수이름 = new 타입[길이];
		// 인덱스(index)의 범위 : 0부터 '배열길이-1'까지
	
	public static void main(String[] args) {
		
		int[] score = new int[5]; // 참조변수 score로 배열 선언, 배열 생성(int 저장공간 x 5)
		score[3]=100;
		
		System.out.println("score[3]= " + score[3]);
		
	}


}
