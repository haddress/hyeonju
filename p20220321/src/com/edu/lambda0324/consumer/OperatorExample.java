package com.edu.lambda0324.consumer;

import java.util.function.IntBinaryOperator;

// Operator : 연산처리 결과

public class OperatorExample {
	public static void main(String[] args) {
		// IntBinaryOperator 인터페이스를 구현하는 구현객체 intBin. intBin에는 기능이 담겨있음
		IntBinaryOperator intBin = (left, right) -> left + right; //intBin은 현재 두 수를 더하는 '기능'(left+right)을 담은 구현객체
		intBin.applyAsInt(10, 20);

		intBin = (num1, num2) -> num1 > num2 ? num1 : num2; // intBin에 두 수 중 큰 값을 구하는 기능을 다시 선언
		int result = maxOrMin(intBin);
		System.out.println(result);

	}
	

	public static int maxOrMin(IntBinaryOperator intBin/* 기능을 가진 intBin 매개변수. 어떤 기능이 들어오느냐에 따라 값이 달라짐 */) {
		int[] intAry = { 85, 47, 92 };
		int result = intAry[0];
		for (int num : intAry) { // result와 num 배열에 들어있는 값 비교
			result = intBin.applyAsInt(result, num);

		}
		return result;
	}

}
