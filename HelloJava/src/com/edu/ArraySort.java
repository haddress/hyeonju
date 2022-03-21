package com.edu;


public class ArraySort {
	public static void sorting(int[] ary) {
		int[] intAry = { 34, 25, 48, 12 };

		int loopCnt = ary.length - 1;

		for (int cnt = 0; cnt < loopCnt; cnt++) {
			int temp = ary[0];
			for (int i = 0; i < loopCnt; i++) {
				if (ary[i] > ary[i + 1]) {
					temp = ary[i];
					ary[i] = ary[i + 1];
					ary[i + 1] = temp;
				}
			}

		}
		for (int i = 0; i < ary.length; i++) {
			System.out.println(ary[i] + " ");
		}
		System.out.println("\nend of prog");
	}

	public static void main(String[] args) { // main메소드는 인스턴스 안만들고 쓸 수 있음
		// int[] intAry => {34, 25, 48, 12}
		int[] intAry = { 34, 25, 48, 12 }; // 제일 마지막 값이 최소값이라고 가정
		// ex)34와 25를 비교해서 뒤의 숫자가 더 크면 위치를 바꿔주는 작업을 해야함. intAry[4]이므로 3번 반복해야함
		int[] intAry2 = { 22, 56, 99, 12 };
		int[] intAry3 = { 22, 56, 99, 12 };
		
		sorting(intAry);
		
		for (int i = 0; i <intAry.length; i++) {
			System.out.println(intAry[i] + " ");
		}
		System.out.println();
		
		sorting(intAry2);
		for (int i = 0; i <intAry.length; i++) {
			System.out.println(intAry2[i] + " ");
		}
		
		
		
		
//		int loopCnt = intAry.length - 1; // 마지막값이 제일 처음위치로 이동하려면 배열크기-1(1을 뺀 횟수만큼 반복하겠습니다)
//
//		for (int cnt = 0; cnt < loopCnt; cnt++) {
//			int temp = intAry[0]; // 첫번째 값으로 temp값을 지정
//			for (int i = 0; i < loopCnt; i++) {
//				if (intAry[i] > intAry[i + 1]) {
//					// 34 25 => 25 34로 위치 변경
//					temp = intAry[i];
//					intAry[i] = intAry[i + 1];
//					intAry[i + 1] = temp;
//				}
//			}
//
//		}
//		for (int i = 0; i < intAry.length; i++) {
//			System.out.println(intAry[i] + " ");
//		}
		System.out.println("\nend of prog");
		
	}

}

// 34와 25를 비교하면 { 25, 34, 48, 12}로 바뀜. 이후 34와 48을 비교하면 바뀌지 않으므로 {25, 34, 38, 12}
// 12가 앞에 올 때까지 반복