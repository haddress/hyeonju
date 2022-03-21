package com.edu.except0321;

public class SlowEx {
	public static void main(String[] args) {
		showInterval("Hell, World\nNice, world");
		
	}
	public static void showInterval(String str) {
		for (int i = 0; i<str.length(); i++) {
			System.out.print(str.charAt(i));
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
