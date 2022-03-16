package com.prod;

public class FriendExample {

	public static void main(String[] args) {
		// 친구의 정보(이름, 전화번호, 이메일, 키, 몸무게)

		Friend f1 = new Friend();
		f1.friendName = "권가희";
		f1.friendPhone = "010-1234-5678";
		f1.email = "kkh@email.com";
		f1.height = 167.5;
		f1.weight = 55.7;

		Friend f2 = new Friend();
		f2.friendName = "이유빈";
		f2.friendPhone = "010-9876-5432";
		f2.email = "lyb@email.com";
		f2.height = 156.5;
		f2.weight = 45.7;

		Friend f3 = new Friend();
		f3.friendName = "나현주";
		f3.friendPhone = "010-9443-6916";
		f3.email = "nhj@email.com";
		f3.height = 176.5;
		f3.weight = 65.7;
		
		System.out.println(f1); // 이 값은 f1의 데이터를 찾아가는 물리적인 주소

		Friend[] friends = { f1, f2, f3 };
		
		for (int i = 0; i <friends.length; i++) {
			if(friends[i].height > 170) {
				System.out.println("이름: " + friends[i].friendName); // friends의 i칸에 있는 friendName
				System.out.println("전화번호:" + friends[i].friendPhone);
				System.out.println("이메일:" + friends[i].email);
				System.out.println("키: " + friends[i].height);
				System.out.println("몸무게: " + friends[i].weight);
				System.out.println("==================================");
			}
			
		}
	}

}
