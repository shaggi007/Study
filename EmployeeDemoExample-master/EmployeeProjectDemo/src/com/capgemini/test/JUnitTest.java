package com.capgemini.test;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.beans.Address;
import com.capgemini.beans.City;
import com.capgemini.beans.Country;
import com.capgemini.repository.EmployeeRepository;
import com.capgemini.repository.EmployeeRepositoryImpl;
import com.capgemini.service.EmployeeService;
import com.capgemini.service.EmployeeServiceImpl;

public class JUnitTest {
	
	EmployeeRepository employeeRepository;
	EmployeeService employeeService;
	
	@Before
	public void setUp() throws Exception {
		employeeRepository = new EmployeeRepositoryImpl();
		employeeService = new EmployeeServiceImpl(employeeRepository);
	}
	
	/*
	 * Create Employee
	 * 1.When Employee Id is already used by some other employee
	 * 2.When Employee Id used as negative employee Id
	 * 3.When Employee name used as null
	 * 4.When Address used as null
	 * 5.When Address line used as null
	 * 6.When All information is used correctly
	 */
	@Test(expected=com.capgemini.exception.ReusedEmployeeIdException.class)
	public void whenEmployeeIdIsAlreadyUsedForAnyOtherEmployeeThenSystemShouldThrowAnException() {
		City delhi = new City("Delhi");
		Country india = new Country("India",delhi);
		employeeService.createEmployee(101, "Rajat", new Address("Adarsh Nagar",india));
	}
	
	@Test(expected=com.capgemini.exception.NegativeEmployeeIdException.class)
	public void whenEmployeeIdIsNegativeForCreationOfEmployeeThenSystemShouldThrowAnException() {
		City delhi = new City("Delhi");
		Country india = new Country("India",delhi);
		employeeService.createEmployee(-105, "Rajat", new Address("Adarsh Nagar",india));
	}
	
	@Test(expected=com.capgemini.exception.NameNullException.class)
	public void whenEmployeeNameIsNullForCreationOfEmployeeThenSystemShouldThrowAnException() {
		City delhi = new City("Delhi");
		Country india = new Country("India",delhi);
		employeeService.createEmployee(105, null, new Address("Adarsh Nagar",india));
	}
	
	@Test(expected=com.capgemini.exception.AddressNullException.class)
	public void whenEmployeeAddressIsNullForCreationOfEmployeeThenSystemShouldThrowAnException() {
		employeeService.createEmployee(106, "Rajat", null);
	}
	
	@Test(expected=com.capgemini.exception.AddressLineNullException.class)
	public void whenEmployeeAddressLineIsNullForCreationOfEmployeeThenSystemShouldThrowAnException() {
		City delhi = new City("Delhi");
		Country india = new Country("India",delhi);
		employeeService.createEmployee(107, "Rajat", new Address(null,india));
	}
	
	@Test
	public void whenAllInformationIsCorrectThenSystemShouldCreateAnEmployee() {
		City delhi = new City("Delhi");
		Country india = new Country("India",delhi);
		employeeService.createEmployee(108, "Rajat", new Address("Adarsh Nagar",india));
	}
	/*
	 * Search Employee By Name
	 * 1.When Employee name used as null
	 * 2.When Employee name is correct
	 */
	
	@Test(expected=com.capgemini.exception.NameNullException.class)
	public void whenEmployeeNameIsNullForSearchingEmployeesThenSystemShouldThrowAnException() {
		employeeService.searchByName(null);
	}
	@Test
	public void whenAllInformationIsCorrectThenSystemShouldReturnAListOfEmployees() {
		employeeService.searchByName("Ram");
	}
}
