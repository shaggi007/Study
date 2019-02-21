package com.capg.employee;

import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main {
	public static void main(String[] args) {

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Employee_Details");
		EntityManager entitymanager = emfactory.createEntityManager();

		
		Query query1 = entitymanager.createQuery("Select MAX(e.salary) from Employee e");
		Double result = (Double) query1.getSingleResult();
		System.out.println("Max Employee Salary :" + result);

		 Query query2 = entitymanager.createQuery( "Select e " + "from Employee e " + "where e.salary " + "Between 30000 and 40000" );
      
      List<Employee> list=(List<Employee>)query.getResultList( );

      for( Employee e:list ){
         System.out.print("Employee ID :" + e.getEid( ));
         System.out.println("\t Employee salary :" + e.getSalary( ));
      }

		
		
		
		Query query = entitymanager.createQuery( "Select e " + "from Employee e " );
	      
	      List<Employee> list=(List<Employee>)query.getResultList( );

	      for( Employee e:list ){
	         System.out.print("Employee ID :" + e.getEid( ));
	         System.out.print("Employee Name :" + e.getEname( ));
	         System.out.println("\t Employee salary :" + e.getSalary( ));
	      }
	      
	      
	     
	      
	      
	      


	}
}
