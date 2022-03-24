package com.edu.lambda0324;

// 매개변수가 있고 반환타입도 있음

interface Runnable3 {
	public int run(String str);
}

public class RunExample3 {
	public static void main(String[] args) {
		Runnable3 runnable = (String str) -> {
			return str.length();
		};
		int lnth = runnable.run("Hell world");
		System.out.println(lnth);
	}
}
