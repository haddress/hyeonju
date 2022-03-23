package com.edu.api0322;

public class IDCheckExample {
	public static void main(String[] args) {
		
		IDCheck idcheck = new IDCheck();
		String result = idcheck.getGender("9503041234567");
		System.out.println(result);
		result = idcheck.getGender("950304-1234567");
		System.out.println(result);

		
		
	}

}
