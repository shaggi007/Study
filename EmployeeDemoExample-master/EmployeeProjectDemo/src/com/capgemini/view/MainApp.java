package com.capgemini.view;

import java.util.List;

import com.capgemini.beans.Address;
import com.capgemini.beans.City;
import com.capgemini.beans.Country;
import com.capgemini.beans.Employee;
import com.capgemini.exception.InvalidEmployeeIdException;
import com.capgemini.repository.EmployeeRepository;
import com.capgemini.repository.EmployeeRepositoryImpl;
import com.capgemini.service.EmployeeService;
import com.capgemini.service.EmployeeServiceImpl;

public class MainApp {

	public static EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
	public static EmployeeService employeeService = new EmployeeServiceImpl(employeeRepository);
	
	public static void main(String[] args) throws InvalidEmployeeIdException {
		City delhi = new City("Delhi");
		City newYork = new City("New York");
		City paris = new City("Paris");
		City canberra = new City("Canberra");
		
		Country india = new Country("India",delhi);
		Country france = new Country("France",paris);
		Country australia = new Country("Australia",canberra);
		Country usa = new Country("United States of America",newYork);
		
		System.out.println(employeeService.createEmployee(101, "Ram", new Address("Block-1",india)));
		System.out.println(employeeService.createEmployee(102, "Smith", new Address("Block-2",usa)));
		System.out.println(employeeService.createEmployee(103, "Robin", new Address("Block-1",france)));
		System.out.println(employeeService.createEmployee(104, "Shyam", new Address("Block-4",india)));
		System.out.println(employeeService.createEmployee(105, "Robin", new Address("Block-5",australia)));
		
		List<Employee> list1 = employeeService.searchByName("Robin");
		for(Employee e:list1) {
			System.out.println(e);
		}
	}

}
