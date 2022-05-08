package co.edu.array;

public class ch5_4_5 {

	public static void main(String[] args) {

		// 배열이름.length : 배열의 길이(int형 상수) -> 배열을 한 번 생성하면 길이를 변경할 수 없음
		int[] arr = new int[5];
		int tmp = arr.length; // arr.length의 값은 5, tmp=5
		System.out.println(tmp);

		for (int i = 0; i < tmp; i++) {
			System.out.println("arr[" + i + "]=" + arr[i]);
		}
		
		// 배열의 초기화: 배열의 각 요소에 처음으로 값을 저장하는 것. 배열은 기본적으로 자동 초기화가 됨(ex. int->0)

	}

}
