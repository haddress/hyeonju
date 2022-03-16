package com.prod;

public class UserExample {

	public static void main(String[] args) {

		User u1 = new User();
		u1.setUserId(100);
		u1.setUserGrade("A");
		u1.setUserPhone("010-1234-5678");
		u1.setUserPoint(5000);

		User u2 = new User();
		u2.setUserId(101);
		u2.setUserGrade("C");
		u2.setUserPhone("010-2345-6789");
		u2.setUserPoint(560);

		User u3 = new User();
		u3.setUserId(102);
		u3.setUserGrade("B");
		u3.setUserPhone("010-3456-7890");
		u3.setUserPoint(1500);

		User u4 = new User();
		u4.setUserId(103);
		u4.setUserGrade("A");
		u4.setUserPhone("010-0123-4567");
		u4.setUserPoint(10000);

		User[] users = { u1, u2, u3, u4 };

		for (int i = 0; i < users.length; i++) {
			if (users[i].getUserGrade() == "A") {
				System.out.println("===================");
				System.out.println("사용자아이디: " + users[i].getUserId());
				System.out.println("사용자등급: " + users[i].getUserGrade());
				System.out.println("사용자연락처: " + users[i].getUserPhone());
				System.out.println("사용자포인트: " + users[i].getUserPoint());
				System.out.println("===================");
			}
			else if (users[i].getUserPoint() >= 1000) {
				System.out.println("===================");
				System.out.println("사용자아이디: " + users[i].getUserId());
				System.out.println("사용자등급: " + users[i].getUserGrade());
				System.out.println("사용자연락처: " + users[i].getUserPhone());
				System.out.println("사용자포인트: " + users[i].getUserPoint());
				System.out.println("===================");
			}
		}

	}

}
