package com.edu.api0323;

import java.util.Calendar;

public class CalendarExample {

	public static void main(String[] args) {

		createCalendar(2022, 7);

	}

	public static void createCalendar(int year, int month) {

		month = month - 1;

		Calendar today = Calendar.getInstance();
		today.set(2022, 6, 1);

		System.out.println("오늘은 " + today.get(Calendar.YEAR) + "년 " + (today.get(Calendar.MONTH) + 1) + "월 "
				+ today.get(Calendar.DATE) + "일 입니다.");
		System.out.println("요일 : " + today.get(Calendar.DAY_OF_WEEK)); // 일:1,
																		// 월:2,
																		// 화:3,
																		// ..
		System.out.println("마지막날의 정보 : " + today.getActualMaximum(Calendar.DATE));

		System.out.println();

		int gapDay = today.get(Calendar.DAY_OF_WEEK);
		int lastDate = today.getActualMaximum(Calendar.DATE);

		String[] days = { "SUN", "MON", "TUE", "WED", "THR", "FRI", "SAT" };
		for (int i = 0; i < days.length; i++) {
			System.out.printf("%4s", days[i]);
		}

		System.out.println();

		for (int i = 1; i < gapDay; i++) {
			System.out.printf("%4s", "");
		}

		for (int i = 1; i <= lastDate; i++) {
			System.out.printf("%4d", i);
			if ((i + gapDay - 1) % 7 == 0) {
				System.out.println();
			}
		}

	}

}

//		// createCalendar 메소드를 사용해서 7월 달력 만들기. + main메소드 밖에서 만들기(?)
//		Calendar today = createCalendar.getInstance();
//		today.set(2022, 6, 1);
//		
//		System.out.println("오늘은 " + today.get(createCalendar.YEAR) + "년 " + (today.get(createCalendar.MONTH)+1) + "월 "
//				+ today.get(createCalendar.DATE) + "일 입니다.");
//
//		System.out.println();
//
//		int gapDay = today.get(Calendar.DAY_OF_WEEK);
//		int lastDate = today.getActualMaximum(Calendar.DATE);
//
//		String[] days = { "SUN", "MON", "TUE", "WED", "THR", "FRI", "SAT" };
//		for (int i = 0; i < days.length; i++) {
//			System.out.printf("%4s", days[i]);
//		}
//
//		System.out.println();
//
//		for (int i = 1; i < gapDay; i++) {
//			System.out.printf("%4s", "");
//		}
//		for (int i = 1; i <= lastDate; i++) {
//			System.out.printf("%4d", i);
//			if ((i + gapDay - 1) % 7 == 0) {
//				System.out.println();
//			}
//		}

//
// 3월 달력 만들기
//		Calendar today = Calendar.getInstance();
//		today.set(2022, 2, 1);
//
//		System.out.println("오늘은 " + today.get(Calendar.YEAR) + "년 " + (today.get(Calendar.MONTH) + 1) + "월 "
//				+ today.get(Calendar.DATE) + "일 입니다.");
////	System.out.println("올해는 : " + today.get(Calendar.YEAR));
////	System.out.println("이번달은 : " + (today.get(Calendar.MONTH)+1)); // 1월:0, 2월:1, 3월:2
////	System.out.println("오늘은 : " + today.get(Calendar.DATE));
//		System.out.println("요일 : " + today.get(Calendar.DAY_OF_WEEK)); // 일:1, 월:2, 화:3, ..
//		System.out.println("마지막날의 정보 : " + today.getActualMaximum(Calendar.DATE));
//
//		System.out.println();
//
//		int gapDay = today.get(Calendar.DAY_OF_WEEK);
//		int lastDate = today.getActualMaximum(Calendar.DATE);
//		
//		String[] days = { "SUN", "MON", "TUE", "WED", "THR", "FRI", "SAT" };
//		for (int i = 0; i < days.length; i++) {
//			System.out.printf("%4s", days[i]);
//		}
//		
//		System.out.println();
//		
//		for(int i = 1; i<gapDay; i++) {
//			System.out.printf("%4s", "");
//		}
//		for(int i = 1; i <= lastDate; i++) {
//			System.out.printf("%4d", i);
//			if ((i+gapDay-1) % 7 == 0) {
//				System.out.println();
//			}
//		}
