package com.shivs76.garage.fullservice.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.shivs76.garage.fullservice.domain.BaseEntity;
import com.shivs76.garage.fullservice.domain.*;

 @Repository
public interface EmployeeDAO extends GenericDAO<Employee, String> {
	 
	 //public List<Employee> findAllByName(String name);
	 

}


