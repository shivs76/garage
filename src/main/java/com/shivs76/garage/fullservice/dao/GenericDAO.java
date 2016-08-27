package com.shivs76.garage.fullservice.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Repository;
import org.springframework.data.repository.Repository;

// import com.shivs76.garage.fullservice.domain.BaseEntity;
import com.shivs76.garage.fullservice.domain.Employee;

@NoRepositoryBean
// public interface GenericDAO<T, ID extends Serializable> extends MongoRepository<T, String> {
public interface GenericDAO<T , ID extends Serializable> extends MongoRepository<T, ID> {
	
	//public void putAll();
	
	public T findByName(String name);
	
	public List<T> findAllByName(String name);
	
	
	
	//public T find(ID id);
	
	// public T saveMe(T b);

}
