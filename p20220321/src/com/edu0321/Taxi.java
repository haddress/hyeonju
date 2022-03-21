package com.edu0321;

public class Taxi extends Vehicle {
	
	public Taxi() {
		super.setMaxSpeed(120);
	}
	

	@Override
	public void run() {
		System.out.println("Texi가 달립니다.");
	
	}

	@Override
	public void stop() {
		System.out.println("Texi가 멈춥니다.");
	}

}
