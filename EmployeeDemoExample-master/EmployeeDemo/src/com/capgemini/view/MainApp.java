package com.capgemini.view;

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
		City sydney = new City("Sydney");
		
		Country india = new Country("India",delhi);
		Country france = new Country("France",paris);
		Country australia = new Country("Australia",sydney);
		Country usa = new Country("United States of America",newYork);
		
		try {
			System.out.println(employeeService.createEmployee(103, "Ram", new Address("Anand Vihar",india)));
			System.out.println(employeeService.createEmployee(104, "Smith", new Address("Houston Street",usa)));
			System.out.println(employeeService.createEmployee(105, "Robin", new Address("Rue des Rosiers",france)));
			System.out.println(employeeService.createEmployee(106, "Shyam", new Address("Adarsh Nagar",india)));
			System.out.println(employeeService.createEmployee(107, "Robin", new Address("George Street",australia)));
		}catch(AddressNullException an) {
			System.out.println(an.getMessage());
		}catch(AddressLineNullException aln) {
			System.out.println(aln.getMessage());
		}catch(NameNullException nn) {
			System.out.println(nn.getMessage());
		}catch(ReusedEmployeeIdException re) {
			System.out.println(re.getMessage());
		}catch(NegativeEmployeeIdException nei) {
			System.out.println(nei.getMessage());
		}
		
		try	{
			List<Employee> list1 = employeeService.searchByName("Robin");
			for(Employee e:list1) {
				System.out.println(e);
			}
		}catch(NameNullException nn) {
			System.out.println(nn.getMessage());
		}catch(NameNotFoundException nnf) {
			System.out.println(nnf.getMessage());
		}
		
	}

}
