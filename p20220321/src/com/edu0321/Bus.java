package com.edu0321;

public class Bus extends Vehicle {
	
	public Bus() {
		super.setMaxSpeed(110);
	}

	@Override
	public void run() {
		System.out.println("Bus가 달립니다.");
	}

	@Override
	public void stop() {
		System.out.println("Bus가 멈춥니다.");
	}
	
	
	
}