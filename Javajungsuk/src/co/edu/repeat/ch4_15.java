package co.edu.repeat;

public class ch4_15 {
	public static void main(String[] args) {
		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.println(i + "*" + j + "=" + (i * j));
			}
			System.out.println();
		} // 구구단 2~9단
		
		for (int i = 1; i<=5; i++) { // i=1~5까지 5번 {} 안의 내용을 반복 (밑으로 몇 줄 찍을지?)
			
			for (int j = 1; j<=10; j++) { // j=1~10까지 반복 (옆으로 몇 개 찍을지?)
				System.out.print("*"); // 줄바꿈없이 *을 10번 찍기 
			}
			System.out.println(); // 10개찍고 줄바꿈
		} // 별찍기
	}
}
