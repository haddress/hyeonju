package com.prod;

public class Employee {
	 private int employeeId;
	 private String employeeName; // employeeName 필드
	 private String department;
	 private String job;
	 private int salary; // 필드 이름도 salary
	 
	 
	 // employeeId
	 public void setEmployeeId(int employeeId) {
		 this.employeeId =  employeeId; // this.employeeId 필드에 employeeID 값을 저장
	 }
	 
	 public int getEmployeeId() {
		 return this.employeeId;
	 }
	 
	 
	 // employeeName
	 public void setEmployeeName(String employeeName) { // set 메소드 : 값을 지정(담아주기위함)
		 this.employeeName = employeeName;
	 }
	 
	 public String getEmployeeName() { // get 메소드 : 값을 불러옴
		 return this.employeeName;
	 }
	 
	 
	 // department
	 public void setDepartment(String department) {
		 this.department = department;
	 }
	 
	 public String getDepartment() {
		 return this.department;
	 }
	 
	 
	 // job
	 public void setJob(String job) {
		 this.job = job;
	 }
	 
	 public String getJob() {
		 return this.job;
	 }
	 
	 // salary
	 public void setSalary(int salary) { // 매개변수도 salary
		 if(salary < 0) {
			 this.salary = 100000; // 0보다 적으면 기본월급 십만원
		 } else {
			 this.salary = salary;
		 }

		 
		 //		 this.salary = salary; // this.를 사용하면서 필드 salary와 매개변수 salary 구분
	 }
	 
	 public int getSalary() {
		 return this.salary;
	 }
	 
	 public String getEmpInfo() {
		 String result = this.employeeName + "의 부서는 " + this.department + "이고 직무는 " //
				 + this.job + "이고 급여는 " + this.salary + " 입니다.";
		 return result;
	 }

}
