package com.shivs76.garage.fullservice.domain;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="manager")
public class Manager extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 4684691463187555873L;
	
	
	
	private String name;
	@Id
	private String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	

}
