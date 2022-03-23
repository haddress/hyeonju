package com.edu.api0322;

public class IDCheck {

	// 주민번호 입력 -> 950304-1234567, 000205-4567890

	public String getGender2/*getGender2라는 메소드 호출*/(String sno/*스트링 타입*/) {
		String newSno = sno.replace("-", ""); // sno안에 "-"(하이픈)같은 문자가 있으면 ""로 대체하겠다는 뜻
		newSno = newSno.replace(" ", "");
		String result = null; // result 변수에 if문 선언
		if (sno.length() == 13) { // 7번째가 성별
			char no = sno.charAt(6);
			if (no == '1' || no == '3') {
				result = "남자";
			} else if (no == '2' || no == '4') {
				result = "여자";
			} else {
				result = "잘못된 번호입니다.";
			}
		} else {
			result = "잘못된 번호입니다.";
		}
		return result;
	}

	public String getGender(String sno) {

//		System.out.println((int) no); // '1'=>49, '2'=>50..
		String result = null; // result값 초기화. result에 값을 넣어 반환하겠다
		if (sno.length() == 14) { // 8번째가 성별
			char no/* 숫자위치변수 정하기 */ = sno.charAt(7);
			if (no == '1' || no == '3') {
				result = "남자";
			} else if (no == '2' || no == '4') {
				result = "여자";
			} else {
				result = "잘못된 번호입니다.";
			}
		} else if (sno.length() == 13) { // 7번째가 성별
			char no = sno.charAt(6);
			if (no == '1' || no == '3') {
				result = "남자";
			} else if (no == '2' || no == '4') {
				result = "여자";
			} else {
				result = "잘못된 번호입니다.";
			}
		} else {
			result = "잘못된 번호입니다.";
		}

		return result;
	}

}
