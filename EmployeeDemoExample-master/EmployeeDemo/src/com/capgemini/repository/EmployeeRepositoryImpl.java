package com.capgemini.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.capgemini.beans.Address;
import com.capgemini.beans.City;
import com.capgemini.beans.Country;
import com.capgemini.beans.Employee;

public class EmployeeRepositoryImpl implements EmployeeRepository {

	public static HashMap<Integer,Employee> employeeRepo = new HashMap<Integer,Employee>();
	
	public EmployeeRepositoryImpl() {
		Employee emp1 = new Employee(101,"Ram",new Address("Anand Vihar", new Country("India",new City("Delhi"))));
		Employee emp2 = new Employee(102,"Smith",new Address("Houston Street", new Country("United States of America", new City("New York"))));
		employeeRepo.put(emp1.getEmployeeId(), emp1);
		employeeRepo.put(emp2.getEmployeeId(), emp2);
	}

	@Override
	public Employee save(Employee employee) {
		int employeeId = employee.getEmployeeId();
		employeeRepo.put(employeeId, employee);
		return employee;
	}

	@Override
	public List<Employee> findByName(String name) {
		List<Employee> employees = new ArrayList<>();
		
		for(Map.Entry<Integer,Employee> entry : employeeRepo.entrySet()) {
			if(entry.getValue().getEmployeeName().equals(name)) {
				employees.add(entry.getValue());
			}
		}
		return employees;
	}

	@Override
	public Employee findById(int employeeId) {
		Employee emp = employeeRepo.get(employeeId);
		return emp;
	}
	
}
