package com.edu.api0322;

import java.util.ArrayList;
import java.util.HashSet;

public class MemberExample {
	public static void main(String[] args) {
		Member obj1 = new Member("user1", "홍길동");
		Member obj2 = new Member("user1", "홍길동");

		if (obj1 == obj2) {
			System.out.println("논리적으로 같습니다..");
		} else {
			System.out.println("논리적으로 다릅니다.");
		}

		// 배열은 한 번 크기가 정해지면 변경시킬때 새로운 배열을 설정해서 복사를 해야하는 단점이 있음
		// 컬렉션(ArrayList, HashSet, HashMap) : 여러개의 값을 저장할 수 있음. 배열과 같은 역할을 하나 더 기능이 좋음
		Member[] memberAry = new Member[5]; // Member의 인스턴스 최대 5개 저장. 
											// 크기 초과할 경우 배열은 새로운 배열을 선언하고 원래 있는 배열을 복사해서 담아줘야함.
		ArrayList<Member> memList = new ArrayList<Member>();
		memList.add(new Member("user1", "홍길동"));
		memList.add(new Member("user1", "홍길동"));
		
		for (int i=0; i<memList.size(); i++) {
			System.out.println(memList.get(i));
		}
		
		HashSet<Member> memSet = new HashSet<Member>();
		memSet.add(new Member("user1", "홍길동")); // hashCode(), equals()
		memSet.add(new Member("user1", "홍길동"));
		
		System.out.println(memSet.size());
	}

}
