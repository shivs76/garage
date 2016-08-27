package com.shivs76.garage.hibernateservice.dao;


import java.util.List;
import java.util.ArrayList;

import com.shivs76.garage.hibernateservice.domain.Employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * EmployeeDAOImpl is an implementation of EmployeeDAO. 
 * And may be one more comment!
 * 1. This will be a commit only.
 * 2. This will be a push as well
 * @author shivs
 *
 */
@Repository(value="EmployeeDAO")
public class EmployeeDAOImpl implements EmployeeDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional(propagation=Propagation.MANDATORY)
	public void save(Employee e) {
		System.out.println("The session factory is " + sessionFactory);
		
		Session aSession = sessionFactory.openSession();
		Transaction tx = aSession.beginTransaction();
		aSession.save(e);
		tx.commit();
		aSession.close();
	}
	
	public void update(Employee e) {
		System.out.println("The session factory is " + sessionFactory);
		
		Session aSession = sessionFactory.openSession();
		Transaction tx = aSession.beginTransaction();
		aSession.update(e);
		tx.commit();
		aSession.close();
	}
	
	public List<Employee> list() {
		
		Session aSession = sessionFactory.openSession();
		List<Employee> all = aSession.createQuery("from Employee").list();
		aSession.close();
		return all;
	}
	
	

}
