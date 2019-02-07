package com.capgemini.service;

import java.util.List;

import com.capgemini.beans.Address;
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
	}

	@Override
	public Employee createEmployee(int employeeId,String employeeName, Address address) {
		Employee emp = employeeRepository.findById(employeeId);
		if(emp!=null) {
			throw new ReusedEmployeeIdException();
		}
		else if(employeeId<0) {
			throw new NegativeEmployeeIdException();
		}
		else if(employeeName==null||employeeName.equals("")) {
			throw new NameNullException();
		}
		else if(address==null) {
			throw new AddressNullException();
		}
		else if(address.getAddressLine()==null||address.getAddressLine().equals("")) {
			throw new AddressLineNullException();
		}
		else {
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		employee.setAddress(address);
		employee.setEmployeeName(employeeName);
		return employeeRepository.save(employee);}
	}

	@Override
	public List<Employee> searchByName(String name) {
		if(name==null||name.equals("")) {
			throw new NameNullException();
		}
		List<Employee> list = employeeRepository.findByName(name);
		if(list==null||list.isEmpty()) {
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
