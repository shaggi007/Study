package com.capgemini.service;

import java.util.List;

import com.capgemini.beans.Address;
import com.capgemini.beans.City;
import com.capgemini.beans.Country;
import com.capgemini.beans.Employee;
import com.capgemini.exception.AddressLineNullException;
import com.capgemini.exception.AddressNullException;
import com.capgemini.exception.InvalidEmployeeIdException;
import com.capgemini.exception.NameNotFoundException;
import com.capgemini.exception.NameNullException;
import com.capgemini.exception.NegativeEmployeeIdException;
import com.capgemini.exception.ReusedEmployeeIdException;
import com.capgemini.repository.EmployeeRepository;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
		City delhi = new City("Delhi");
		City newYork = new City("New York");
		City paris = new City("Paris");
		
		Country india = new Country("India",delhi);
		Country france = new Country("France",paris);
		Country usa = new Country("United States of America",newYork);
		
//		createEmployee(106, "Ram", new Address("Anand Vihar",india));
//		createEmployee(107, "Smith", new Address("Houston Street",usa));
//		createEmployee(108, "Robin", new Address("Marais",france));
//		createEmployee(101, "Rajat", new Address("Adarsh Nagar",india));
		}

	@Override
	public Employee createEmployee(int employeeId,String employeeName, Address address) {
		Employee emp = employeeRepository.findById(employeeId);
		System.out.println(" "+employeeName+"  "+address);
				if(emp!=null) {
			throw new ReusedEmployeeIdException();
		}
		if(employeeId<0) {
			throw new NegativeEmployeeIdException();
		}
		if(employeeName==null) {
			throw new NameNullException();
		}
		if(address==null) {
			throw new AddressNullException();
		}
		if(address.getAddressLine()==null) {
			throw new AddressLineNullException();
		}
		Employee employee = new Employee();
		System.out.println(" "+employeeName+"  "+address);
		employee.setEmployeeId(employeeId);
		employee.setAddress(address);
		employee.setEmployeeName(employeeName);
		System.out.println(" "+employeeName+"  "+address);
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> searchByName(String name) {
		if(name==null) {
			throw new NameNullException();
		}
		List<Employee> list = employeeRepository.findByName(name);
		if(list==null) {
			throw new NameNotFoundException();
		}
		return list;
	}

	@Override
	public Employee searchById(int employeeId) {
		if(employeeId<0) {
			throw new NegativeEmployeeIdException();
		}
		Employee employee = employeeRepository.findById(employeeId);
		if(employee==null) {
			throw new InvalidEmployeeIdException();
		}
		return employee;
	}

	

}
