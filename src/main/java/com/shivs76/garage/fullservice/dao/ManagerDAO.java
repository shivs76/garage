package com.shivs76.garage.fullservice.dao;

import org.springframework.stereotype.Repository;

import com.shivs76.garage.fullservice.domain.Manager;

@Repository
public interface ManagerDAO extends GenericDAO<Manager, String> {
	
}