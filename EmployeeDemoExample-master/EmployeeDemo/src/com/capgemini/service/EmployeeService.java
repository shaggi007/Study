package com.capgemini.service;

import java.util.List;

import com.capgemini.beans.Address;
import com.capgemini.beans.Employee;

public interface EmployeeService {

	public Employee createEmployee(int employeeId, String employeeName, Address address);
	public List<Employee> searchByName(String name);
	public Employee searchById(int employeeId);
	
}
