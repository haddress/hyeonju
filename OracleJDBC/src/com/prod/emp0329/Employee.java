package com.prod.emp0329;

public class Employee {
	// employees 테이블의 칼럼들에 해당되는 각 요소들을 담아놓기 위한 필드설정

	private int employeeId; // employees.employee_id
	private String firstName; // employees.first_name
	private String lastName; // employees.last_name
	private String email;
	private int salary;
	private String hireDate;
	private String jobId;
	private String phoneNumber;

	// 기본 생성자 ---------------------------

	public Employee() {

	}

	// ------------------------------------

	// 생성자 -------------------------------

	public Employee(int employeeId, String firstName, String lastName, String email, int salary, String hireDate,
			String jobId, String phoneNumber) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.salary = salary;
		this.hireDate = hireDate;
		this.jobId = jobId;
		this.phoneNumber = phoneNumber;
	}
	
	// ------------------------------------

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", salary=" + salary + ", hireDate=" + hireDate + ", jobId=" + jobId + ", phoneNumber="
				+ phoneNumber + "]";
	}

}
