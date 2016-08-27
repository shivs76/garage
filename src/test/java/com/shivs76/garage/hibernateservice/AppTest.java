package com.shivs76.garage.hibernateservice;

import org.springframework.context.support.FileSystemXmlApplicationContext;


import com.shivs76.garage.hibernateservice.domain.Employee;
import com.shivs76.garage.hibernateservice.dao.EmployeeDAO;

import java.util.Arrays;
import org.junit.Test;
import java.util.List;



/**
 * Unit test for simple App.
 */
public class AppTest 
{
	@Test
	public void doGenericWay() {
		org.springframework.context.support.FileSystemXmlApplicationContext fff = 
				new FileSystemXmlApplicationContext("C:\\projects\\garagews\\hibernateservice\\src\\main\\resources\\mvc-dispatcher-servlet.xml");
		// GenericDAO<Employee, String> tt1 = fff.getBean(GenericDAO.class);
		// org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
		 //   java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.WARNING); //or whatever level you need

		EmployeeDAO tt = fff.getBean(EmployeeDAO.class);
		Employee e = new Employee();
		e.setDeptId(10);
		e.setName("Toe");
		e.setSalary(5000);
		e.setId(700);
		tt.save(e);
		System.out.println("Employee is "  + e);
		
		List<Employee> eL = tt.list();
		eL.forEach(System.out::print);
		
		
	}
}
