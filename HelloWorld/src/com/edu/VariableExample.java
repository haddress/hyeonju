package com.edu;
 
public class VariableExample {
	public static void main(String[] args) {
		// 변수의 타입
		int num1 = 100; // int는 정수, 4byte
		double num2 = 100.5; // double은 실수. 소수점까지 표현, 8byte
		double result = num1 * num2; // int와 double을 곱할 경우, 더 타입 크기가 큰 double로
		// 자동형변환(promotion) : 작은범위 -> 큰범위
		System.out.println("결과: " + result);
		
		// 강제형변환(casting) : 큰범위 -> 작은범위
		int val1 = 100;
		double val2 = 20.5; // 강제형변환 한 경우, 0.5를 버려서 20이 됨
		int sum = val1 + (int) val2;
		System.out.println("결과: " + sum);
		
		int n1 = 11;
		int n2 = 4;
		double n3 = (double) n1 / n2; // 10/4 => 2.5로 표현하고 싶을 경우 결과값을 double타입으로 받아야하는데. int를 사용하면 둘 다 int인 정수연산이므로 0.5가 날아감. 따라서 (double)로 형변환 필요
		System.out.println("나눈 결과: " + n3);
		
		// 나머지 10을 4로 나눈 나머지 => 1 을 계산하는 방법 = %
		int n4 = n1 % n2;
		System.out.println("나머지: " + n4);
		
		// 짝수, 홀수
		if(n1 % 2 == 1) { // ==는 왼쪽의 값과 오른쪽의 값을 비교한다는 뜻
			System.out.println(n1 + "의 값은 홀수입니다.");
		};
		
	}

}
