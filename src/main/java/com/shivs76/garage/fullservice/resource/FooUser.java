package com.shivs76.garage.fullservice.resource;

import java.io.Serializable;

public class FooUser implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public long userId;
	
	public String userName;
	
	public String userDescription;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserDescription() {
		return userDescription;
	}

	public void setUserDescription(String userDescription) {
		this.userDescription = userDescription;
	}
	
	public String toString() {
		return "User{id:" + userId + " name:" + userName + " description:" + userDescription + "}";
	}

}
