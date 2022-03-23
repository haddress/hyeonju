package com.edu.api0323;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class DateExample {
	public static void main(String[] args) {
		
		Date today = new Date("2022/01/01 00:00:00");
		today.setYear(1);
		System.out.println(today);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년MM월dd일 hh시mm분55초");
		System.out.println(sdf.format(today));
		
		LocalDateTime time = LocalDateTime.now();
		System.out.println(time.getYear() + "년");
		
	}

}
