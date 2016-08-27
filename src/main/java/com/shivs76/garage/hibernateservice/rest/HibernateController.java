package com.shivs76.garage.hibernateservice.rest;

import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping (value="/hc")
@RestController
public class HibernateController {
	
	@RequestMapping(path="donothing", method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE )
	public String doThing() {
		return "200";
	}

}
