package com.shivs76.garage.hibernateservice.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.shivs76.garage.hibernateservice.domain.Employee;

@Repository
public interface EmployeeDAO {
	
	public void save(Employee e);
	
	public List<Employee> list();
	
	

}
