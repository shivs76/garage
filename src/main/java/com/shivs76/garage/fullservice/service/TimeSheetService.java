package com.shivs76.garage.fullservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shivs76.garage.fullservice.dao.TaskDAO;
import com.shivs76.garage.fullservice.dao.TimeSheetDAO;
import com.shivs76.garage.fullservice.domain.BaseEntity;
import com.shivs76.garage.fullservice.domain.Task;
import com.shivs76.garage.fullservice.domain.TimeSheet;

@Service
public class TimeSheetService {
	
	@Autowired
	private TimeSheetDAO aTSDAO;
	
	public List<TimeSheet> list() {
		return aTSDAO.findAll();
	}
	
	public void add(TimeSheet b) {		
		aTSDAO.save(b);		
	}


}
