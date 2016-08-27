package com.shivs76.garage.fullservice.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.shivs76.garage.fullservice.domain.Employee;
import com.shivs76.garage.fullservice.domain.Task;

@Repository
public interface TaskDAO extends GenericDAO<Task, String> {
	
	// public Task findByName(String name);
	
	@Query("{employeeList.name:?0}")
	public List<Task> findTaskByEmployee(String empName);
	
	//@Query(value="{manager.name=?0}")
	public List<Task> findTaskByManager(String manager);
	
	
	//public List<T> findAllManager(String manager);
	
}