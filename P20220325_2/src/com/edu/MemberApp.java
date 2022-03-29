package com.edu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MemberApp {

	List<Member> members = new ArrayList<Member>();

	Scanner scn = new Scanner(System.in);

	// MemberService----------------------------
	class MemberServiceImpl implements MemberService {

		@Override
		public void addMember(Member member) {
			members.add(member);
		}

		@Override
		public void modifyMember(Member member) {

			for (int i = 0; i < members.size(); i++) /*Member mbr : members*/{
				if (members.get(i).getMemberId() == member.getMemberId())
					/*mbr.getMemberId() == member.getMemberId()*/ {
					members.get(i).setPhone(member.getPhone());
					/*mbr.setPhone(member.getPhone());*/
				}
			}

		}

		@Override
		public List<Member> memberList() {
			return members;
		}

	}
	// --------------------------------------------

	public void execute() {
		// 메뉴: 1.등록 2.수정 3.전체리스트 9.종료
		// 도서반 => 기본정보 + 도서반장이름, 강의실이름
		// 축구반 => 기본정보 + 코치이름, 라커룸이름
		// 수영반 => 기본정보 + 강사이름, 수영등급
		MemberService service = new MemberServiceImpl();

		while (true) {
			int menu = 0;
			while (true) {
				try {
					System.out.println("1.등록 | 2.수정 | 3.전체리스트 | 9.종료");
					System.out.print("선택>> ");

					// 메뉴입력
					menu = scn.nextInt();
					System.out.println("============================");
					break;
				} catch (InputMismatchException e) {
					System.out.println("============================");
					System.out.println("숫자를 입력하세요.");
					System.out.println("============================");
					scn.next();
				}
				
			} // 예외처리 While문
			
			// 메뉴-----------------------------------
			if (menu == 1) {
				System.out.println("============================");
				System.out.println("수강클래스");
				System.out.println("1) 도서반 | 2) 축구반 | 3) 수영반");
				System.out.print("선택>> ");
				int submenu = scn.nextInt();
				System.out.println();
				
				if (submenu == 1) {
					System.out.print("회원 아이디 입력>> ");
					int memberId = scn.nextInt();
					System.out.print("회원 이름 입력>> ");
					String memberName = scn.next();
					System.out.print("회원 휴대폰번호 입력>> ");
					String phone = scn.next();
					System.out.print("도서반장 이름 입력>> ");
					String leader = scn.next();
					System.out.print("강의실 이름 입력>> ");
					String classRoom = scn.next();

					Member m1 = new BookMember(memberId, memberName, phone, leader, classRoom);
					service.addMember(m1);

				} else if (submenu == 2) {
					System.out.print("회원 아이디 입력>> ");
					int memberId = scn.nextInt();
					System.out.print("회원 이름 입력>> ");
					String memberName = scn.next();
					System.out.print("회원 휴대폰번호 입력>> ");
					String phone = scn.next();
					System.out.print("코치 이름 입력>> ");
					String coach = scn.next();
					System.out.print("락커룸 번호 입력>> ");
					String locker = scn.next();

					Member m2 = new SoccerMember(memberId, memberName, phone, coach, locker);
					service.addMember(m2);

				} else if (submenu == 3) {
					System.out.print("회원 아이디 입력>> ");
					int memberId = scn.nextInt();
					System.out.print("회원 이름 입력>> ");
					String memberName = scn.next();
					System.out.print("회원 휴대폰번호 입력>> ");
					String phone = scn.next();
					System.out.print("강사 이름 입력>> ");
					String teachName = scn.next();
					System.out.print("수영 등급 입력>> ");
					String swimGrade = scn.next();

					Member m3 = new SwimMember(memberId, memberName, phone, teachName, swimGrade);
					service.addMember(m3);

				} else {
					System.out.println("잘못된 메뉴를 선택하셨습니다.");
					System.out.println("============================");
					System.out.println();
				}
				System.out.println();
				System.out.println("저장완료");
				System.out.println("============================");
				System.out.println();

			} else if (menu == 2) {
				System.out.print("수정할 회원 아이디 입력>> ");
				int memberId = scn.nextInt();
				System.out.print("회원 이름 입력>> ");
				String memberName = scn.next();
				System.out.print("회원 휴대폰번호 입력>> ");
				String phone = scn.next();

				Member m = new Member(memberId, memberName, phone);
				service.modifyMember(m);
				System.out.println("처리가 완료되었습니다.");
				System.out.println("============================");
				System.out.println();

			} else if (menu == 3) {
				List<Member> memberList = service.memberList();
				for (Member m : memberList) {
					System.out.println("============================");
					System.out.println(m.toString());
					System.out.println("============================");
				}
				System.out.println();

			} else if (menu == 9) {
				System.out.println("프로그램을 종료합니다.");
				System.out.println();
				break;
			} else {
				System.out.println("잘못된 메뉴를 선택하셨습니다.");
				System.out.println("============================");
				System.out.println();
			}
		}
		
		// 교수님 코드
//		while (true) {
//			System.out.println("1.등록 | 2.수정 | 3.전체리스트 | 9.종료");
//			System.out.print("선택>> ");
//			menu = scn.nextInt();
//			
//			if(menu == 1) {
//				System.out.println("1) 도서반 | 2) 축구반 | 3) 수영반");
//				int submenu = scn.nextInt();
				
				// 공통질문----
//				System.out.print("회원 아이디 입력>> ");
//				int memberId = scn.nextInt();
//				System.out.print("회원 이름 입력>> ");
//				String memberName = scn.next();
//				System.out.print("회원 휴대폰번호 입력>> ");
//				String phone = scn.next();
//				members.add(new BookMember()); // 부모>자식
				// ----공통질문끝
				
//				if (submenu == 1) {
//					System.out.print("도서반장 이름 입력>> ");
//					String leader = scn.next();
//					System.out.print("강의실 이름 입력>> ");
//					String classRoom = scn.next();
		
//					service.addMember(new BookMember(memberId, memberName, phone, leader, classRoom)); // 바로 변수에 넣어줘도 됨
//				} else if (submenu == 2) {
//					System.out.print("코치 이름 입력>> ");
//					String coach = scn.next();
//					System.out.print("락커룸 번호 입력>> ");
//					String locker = scn.next();
//				} else if (submenu == 3) {
//					System.out.print("강사 이름 입력>> ");
//					String teachName = scn.next();
//					System.out.print("수영 등급 입력>> ");
//					String swimGrade = scn.next();
//				} else {
//					
//				}
//				
//			}
//		}
		
		System.out.println("end of prog");
	}
	

	

}