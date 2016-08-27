package com.shivs76.garage.fullservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shivs76.garage.fullservice.dao.TaskDAO;
import com.shivs76.garage.fullservice.domain.Task;
import com.shivs76.garage.fullservice.domain.TimeSheet;

@Service
public class TaskService {
	
	@Autowired
	private TaskDAO aTaskDAO;
	
	public List<Task> list() {
		return aTaskDAO.findAll();
	}
	
	
	public void add(Task b) {		
		aTaskDAO.save(b);		
	}

}
