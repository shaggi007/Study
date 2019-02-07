package com.capgemini.beans;

public class Employee {
	private int employeeId;
	private String employeeName;
	private Address address;
	
	public Employee() {
		super();
	}
	public Employee(int employeeId, String employeeName, Address address) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.address = address;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	@Override
	public String toString() {
		return "Employee:\nEmployee Id : " + employeeId + ", Employee Name : " + employeeName + ", \nAddress : " + address+"\n*****************************************";
	}
	
}
