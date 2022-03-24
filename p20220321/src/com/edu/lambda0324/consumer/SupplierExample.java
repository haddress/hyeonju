package com.edu.lambda0324.consumer;

import java.util.function.IntSupplier;

public class SupplierExample {
	public static void main(String[] args) {

//		IntSupplier intSup = new IntSupplier() {
//
//			@Override
//			public int getAsInt() {
//				return (int) (Math.random() * 10);
//			}
//
//		};
		
		IntSupplier intSup = () -> (int) (Math.random() * 10); // 람다식
		
		int result = intSup.getAsInt();
		System.out.println("결과값은 " + result);
	}
}
