package com.edu0321;

public class DriverExample {
	public static void main(String[] args) {

		Vehicle v1 = new Vehicle();
		v1 = new Taxi();
		v1 = new Bus();

		Driver driver = new Driver();
		driver.drive(v1); // 매개변수의 다형성

		Vehicle vehicle = new Vehicle();
		Taxi taxi = new Taxi();
		Bus bus = new Bus();

		System.out.println("vehivle의 최고 속력: " + vehicle.getMaxSpeed());
		System.out.println("Taxi의 최고 속력: " + taxi.getMaxSpeed());
		System.out.println("Bus의 최고 속력: " + bus.getMaxSpeed());

		Vehicle[] vehicles = new Vehicle[3];
		vehicles[0] = vehicle;
		vehicles[1] = taxi;
		vehicles[2] = bus;

		// 속도가 제일 빠른 것부터 정렬해서 vehicles[0]=taxi, vehicles[1]=bus, vehicles[2]=vehicle
		// if(intAry[i]. > intAry[i+1]
		// if(vehicles[i].getMaxSpeed 크다 작다 비교

		int loopCnt = vehicles.length - 1;
		Vehicle temp = vehicles[0];
		for (int cnt = 0; cnt < loopCnt; cnt++) {
			for (int i = 0; i < loopCnt; i++) {
				if (vehicles[i].getMaxSpeed() < vehicles[i + 1].getMaxSpeed()) {
					temp = vehicles[i]; //
					vehicles[i] = vehicles[i + 1]; //
					vehicles[i + 1] = temp; // 뒤에 있는 애가 더 빠르면 위치를 바꿔주는 작업
				}
			}
		}
		System.out.println("제일 빠른 거: " + vehicles[0].toString()); // 택시의 최고속도는 120입니다.
		System.out.println("제일 느린 거: " + vehicles[2].toString());
		
		
		

//		int loopcnt = vehicles.length - 1;

//		for (int cnt = 0; cnt < vehicles.length - 1; cnt++) {
//			int temp = vehicle.getMaxSpeed();
//			for (int i = 0; i < vehicles.length - 1; i++) {
//				if (vehicles[i].getMaxSpeed() > vehicles[i + 1].getMaxSpeed()) {
//					temp = vehicles[i].getMaxSpeed();
//					vehicles[i].setMaxSpeed(vehicles[i + 1].getMaxSpeed());
//					vehicles[i + 1].setMaxSpeed(temp);
//
//				}
//			}
//
//		}
//		for (int i = 0; i < vehicles.length; i++) {
//			System.out.println(vehicles[i].getMaxSpeed());
//		}

	}

}
