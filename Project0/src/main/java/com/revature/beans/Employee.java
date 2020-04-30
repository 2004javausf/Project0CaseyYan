package com.revature.beans;

public class Employee {
	
	private String EmployeeUsername;
	private String EmployeePassword;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String employeeUsername, String employeePassword) {
		super();
		EmployeeUsername = employeeUsername;
		EmployeePassword = employeePassword;
	}

	public String getEmployeeUsername() {
		return EmployeeUsername;
	}

	public void setEmployeeUsername(String employeeUsername) {
		EmployeeUsername = employeeUsername;
	}

	public String getEmployeePassword() {
		return EmployeePassword;
	}

	public void setEmployeePassword(String employeePassword) {
		EmployeePassword = employeePassword;
	}

	@Override
	public String toString() {
		return "Employee [EmployeeUsername=" + EmployeeUsername + ", EmployeePassword=" + EmployeePassword + "]";
	}
	
	

}
