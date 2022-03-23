package sec01.exam;

public class IDCheck {
	// 주민번호 입력 -> 950304-1234567, 000205-4567890
	// 950304-1234567, 950304 1234567, 9503041234567

	// String getGender() -> 남자, 여자

	
	
	public String getGender(String sno) {
//		IDCheck idcheck = new IDCheck();
//		String result = idcheck.getGender("9503041234567");
//		result = idcheck.getGender("950304-1234567");
		
		String result = "";
		
		if (result.length() == 13) {
			char getGender = result.charAt(7);
			switch (getGender) {
			case '1':
			case '3':
				break;
			case '2':
			case '4':
				break;
			}
			return result;
		} else {
			char getGender = result.charAt(8);
			switch (getGender) {
			case '1':
			case '3':
				break;
			case '2':
			case '4':
				break;
			}

		}
		return result;

	}
}
