package co.edu.repeat;

import java.util.Scanner;

public class ch4_20_24 {

	public static void main(String[] args) {
		
		// break문
		int sum = 0;
		int i = 0;
		
		while(sum <= 100) { // 무한 반복문. for문으로 쓴다면 for(;;){} 으로 사용가능
//			if (sum > 100) { // sum이 100보다 작거나 같을 경우에는 계속 while문 실행
//				break; // 자신이 속한 하나의 반복문을 벗어남
//			}
			++i;
			sum += i;
		}
		System.out.println("i=" + i);
		System.out.println("sum=" + sum);
		System.out.println();
		
		// continue문 : 다음 반복으로 넘어감(건너뜀)
		for (i=0; i<=10; i++) {
			if (i%2 == 0) { // 2의 배수일 경우에는 건너뜀(출력되지 않음)
				continue;
			}
			System.out.println(i);
		}
		System.out.println();
		
		// break, countinue 예제
		int menu = 0;
		int num = 0;
		
		Scanner scan = new Scanner(System.in);
		
		while(true) { // 무한 반복문
			System.out.println("(1) Square");
			System.out.println("(2) Square root");
			System.out.println("(3) Log");
			System.out.print("원하는 메뉴(1~3)를 선택하세요. (종료:0) >>");
			
			String tmp = scan.nextLine(); // 화면에서 입력받은 내용을 tmp에 저장
			menu = Integer.parseInt(tmp); // 입력받은 문자열tmp를 int타입으로 변환
			
			if (menu == 0) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else if (!(1<=menu && menu<=3)) {
				System.out.println("메뉴를 잘못선택하셨습니다.");
				continue;
			}
			System.out.println("선택하신 메뉴는 " + menu +"번 입니다.");
			break;
		}
		
		// 이름붙은 반복문 : 둘 이상의 반복문을 벗어나고 싶을 때는, 반복문에 이름을 붙이고 break문에 이름을 쓰면 됨
		
		
	}
}
