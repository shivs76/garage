package com.shivs76.garage.fullservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shivs76.garage.fullservice.dao.ManagerDAO;
import com.shivs76.garage.fullservice.dao.TaskDAO;
import com.shivs76.garage.fullservice.domain.Employee;
import com.shivs76.garage.fullservice.domain.Manager;
import com.shivs76.garage.fullservice.domain.TimeSheet;

@Service
public class ManagerService {
	
	@Autowired
	private ManagerDAO aManagerDOA; 
	
	@Autowired
	private TaskDAO aTaskDAO;
	
	public void removeManager(String managerName) {
		// Ensure that manager is not assigned to any task.
		if(aTaskDAO.findTaskByManager(managerName).isEmpty()) {
			System.out.println("Well no manager assigned to a task... delete em");
			aManagerDOA.delete(aManagerDOA.findAllByName(managerName));
			System.out.println("Deleted!");
			
		} else {
			 System.out.println("Some manager found some where!");
		}
	}
	
	public void add(Manager b) {		
		aManagerDOA.save(b);		
	}
	
	public boolean isManagerPresent(Manager e) {
		Manager fromDB = aManagerDOA.findByName(e.getName());
		return (fromDB != null);
	}

}
