package com.shivs76.garage.fullservice.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.shivs76.garage.fullservice.domain.TimeSheet;

// @Repository
public interface TimeSheetDAO extends GenericDAO<TimeSheet, String> {
	
	@Query(value="{owner.name:?0}")
	public List<TimeSheet> findByEmployee(String e1);
	
}