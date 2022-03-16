package com.prod;

public class ArrayExample3 {
	public static void main(String[] args) {
		String[] names = new String[5];
		names[0] = "홍길동";
		names[1] = "234";
		names[2] = "조수연";
		names[3] = "황진주";

		names[1] = "이삼사";
		names[4] = "나현주";

		names[0] = null;

		String searchName = "나현주";

		for (int i = 0; i < 5; i++) {
//			if(names[i] != null) {
//				System.out.println("이름: " + names[i]);
//			}
			if (names[i] != null && names[i].equals(searchName)) { // null이 아닌 값 중에서 찾겠다는 뜻
				System.out.println(i + 1 + "번째 위치에 있습니다.");
			}
		}
	}

}
