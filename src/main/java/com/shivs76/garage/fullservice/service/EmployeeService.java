package com.shivs76.garage.fullservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.shivs76.garage.fullservice.dao.EmployeeDAO;
import com.shivs76.garage.fullservice.dao.TaskDAO;
import com.shivs76.garage.fullservice.dao.TimeSheetDAO;
import com.shivs76.garage.fullservice.domain.Employee;
import com.shivs76.garage.fullservice.domain.TimeSheet;

@Service
public class EmployeeService {
	
	@Autowired
	private TaskDAO aTaskDAO;
	
	@Autowired
	private TimeSheetDAO aTimeSheetDAO;
	
	@Autowired
	private EmployeeDAO aEmpDAO;
	
	public void add(Employee b) {		
		aEmpDAO.save(b);		
	}
	
	public boolean isEmployeePresent(Employee e) {
		Employee fromDB = aEmpDAO.findByName(e.getName());
		return (fromDB != null);
	}
	
	public void removeEmployee(String e1) {
		
		
		// first call the taskdao and get the list of employee
		if(aTaskDAO.findTaskByEmployee(e1).isEmpty()&& aTimeSheetDAO.findByEmployee(e1).isEmpty()) {
			System.out.println("The employee is not found!");
			// A task is not associated to an employee..So go ahead and remove it
			 // aEmpDAO.delete(aEmpDAO.findByName(e1));
			aEmpDAO.delete(aEmpDAO.findAllByName(e1));
			System.out.println("Employee gone....");
			
			
		} else {
			System.out.println("hmmmmm " );
		}
		
	}

}
