package com.capgemini.repository;

import java.util.List;

import com.capgemini.beans.Employee;

public interface EmployeeRepository {
	
	public Employee save(Employee employee);
	public List<Employee> findByName(String name);
	public Employee findById(int employeeId);
	
}
