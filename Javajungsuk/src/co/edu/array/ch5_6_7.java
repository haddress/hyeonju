package co.edu.array;

import java.util.Arrays;

public class ch5_6_7 {
	public static void main(String[] args) {

		// 배열의 출력

		int[] iArr = { 100, 95, 80, 70, 60 }; // 길이가 5인 int배열
		System.out.println(Arrays.toString(iArr)); // Arrays.toString() -> 배열 iArr의 모든 요소를 문자열[] 형태로 출력한다.
		System.out.println();

		for (int i = 0; i < iArr.length; i++) {
			System.out.println(iArr[i]);
		}
		System.out.println();

		int[] iArr2 = new int[10];
		for (int i = 0; i < iArr2.length; i++) {
			iArr2[i] = (int) (Math.random() * 10) + 1;
		}
		System.out.println(Arrays.toString(iArr2));
		

	}
}
