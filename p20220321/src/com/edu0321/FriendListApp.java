package com.edu0321;

public class FriendListApp {
	public static void main(String[] args) {
		Friend[] friends = new Friend[10];

		Friend f1 = new Friend();
		f1.setName("진휘용");
		f1.setAge(25);
		f1.setHeight(178.3);
		f1.setWeight(68.9);
		f1.setPhone("010-2323-9845");

		UnivFriend f2 = new UnivFriend("서현일", 29, 178.3, 69.2, "010-1111-2222");
		f2.setUniversity("대구대학교");
		f2.setMajor("컴퓨터공학과");

		ComFriend f3 = new ComFriend("최규완", 29, 179.3, 75.2, "010-1341-7349", "네이버", "지도app개발연구원");

		Friend f4 = new Friend();
		f4.setName("김김김");
		f4.setAge(26);
		f4.setHeight(168.3);
		f4.setWeight(78.9);
		f4.setPhone("010-5757-5757");

		UnivFriend f5 = new UnivFriend("이이이", 25, 183.3, 75.2, "010-1212-2222");
		f5.setUniversity("대구대학교");
		f5.setMajor("국어국문학과");

		ComFriend f6 = new ComFriend("최최최", 28, 173.1, 68.5, "010-5345-7777", "라인", "채팅app개발연구원");

		friends[0] = f1;
		friends[1] = f2;
		friends[2] = f3;
		friends[3] = f4;
		friends[4] = f5;
		friends[5] = f6;

		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null && friends[i] instanceof UnivFriend)
				System.out.println(friends[i].toString()); // 동일한 기능이지만 인스턴스종류에 따라 다른 결과 실행
		}

		Friend friend = f2; // UnivFriend;, f2는 학교이름+전공이 담겨있는데 그냥 friend class에 담겨져버리면 getUniversity와
							// getMajor이 누락. 부모클래스의 참조변수에 저장된 값만 출력 가능
//		Friend friend = (Friend) f2;
		friend = f1;
		UnivFriend uni = null;
		if (friend instanceof UnivFriend) { // uni 참조변수에 담겨있는 값이 UnivFriend의 인스턴스인지 확인한 후에
			uni = (UnivFriend) friend; // Casting 해야함. (UnivFriend로 강제형변환, Univ가 갖고있는 것 사용가능)
			uni.getUniversity(); // 부모클래스의 참조변수를 자식클래스의 참조변수로 할당 가능
		}

	}
}
