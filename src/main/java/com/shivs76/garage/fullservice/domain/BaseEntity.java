package com.shivs76.garage.fullservice.domain;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class BaseEntity {
	
	
	private Date createdDate;
	
	private Date modifiedDate;
	
	

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	
	
	
	
	
	
	

}
