package com.dev;

import java.util.Scanner;

public class IfExample2 {
	public static void main(String[] args) {
		// 물건가격이 50000원 이상이면 배송비 0
		// 그 외에는 배송비 3000원
		
		// 결제할 금액이 얼마인지를 보여주는 코드
		
		Scanner scn = new Scanner(System.in);
//		int price, shippingFee = 3000;
		
		System.out.println("물건의 가격을 입력하시오.");
		int price = scn.nextInt();
		int shippingFee = 3000;
		
		if(price >= 50000) {
			System.out.println("결제할 금액은 " + price + "원 입니다.");
		} else {
			System.out.println("결제할 금액은 " + (price + shippingFee) + "원 입니다.");
		}
		
//		if(price >= 50000) {
//			price = price;
//		} else {
//			price = price + shippingFee;
//		}
//		price = (price >= 50000) ? price : price + shippingFee; -> if-else문을 이렇게 간단한 문장으로 표현할 수 있음
//		
//		System.out.println("결제할 금액은 " + price + "원 입니다.");
//		
		scn.close();
	}

}
