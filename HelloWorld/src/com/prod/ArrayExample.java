package com.prod;

public class ArrayExample {
	public static void main(String[] args) {
		long l1 = 123456543341234L; // 기본적으로 int로 인식하므로, 큰 숫자 입력 시 L을 입력하여 long타입임을 알려줌. 8byte
		int i1 = 100; // 데이터를 담을 수 있는 메모리의 크기가 4byte
		byte b1 = 127; // 데이터를 담을 수 있는 메모리의 크기가 1byte (-128 ~ 127)
		b1++;
		b1++;
		short s1 = 100; // 2byte, -32768 ~ 32767
//		System.out.println(Short.MAX_VALUE);

		int sum = 0;
		int score1 = 80;
		int score2 = 90;
		int score3 = 85;
		int score4 = 95;
		int score5 = 88;

		sum += score1;
		sum += score2;
		sum += score3;
		sum += score4;
		sum += score5;

		double avg = sum / (double) 5;

		int[] scores = new int[5];

		scores[0] = 80;
		scores[1] = 90;
		scores[2] = 85;
		scores[3] = 95;
		scores[4] = 88;

//		System.out.println(scores[0] + scores[1]);

		// 배열을 활용해서 sum => avg
		sum = 0;
		for (int i = 0; i < 5; i++) {
//			System.out.println(scores[i]);
			sum += scores[i];
		}
		avg = sum / (double) 5;
		System.out.println("평균은 " + avg + "입니다.");

	}

}
