package com.shivs76.garage.fullservice.rest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shivs76.garage.fullservice.resource.FooUser;

@RestController
@RequestMapping(path="/fsc")
public class FullServiceController {
	
	@RequestMapping(method = RequestMethod.GET,			
			path="/foo", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public FooUser goFoo() {
		System.out.println("This is foooo you fooo...l");
		FooUser foo = new FooUser();
		foo.setUserDescription("A new user");
		foo.setUserName("shivs76");
		foo.setUserId(100L);
		int c = 0;
		//c = 100/c;
		
		return foo;
	}
	
	
	@RequestMapping(method = RequestMethod.POST,			
			path="/foo/set", 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public void setFoo(@RequestBody FooUser foo, @RequestHeader(value="Authorization") String someThing) {
		System.out.println("and the foo is " + foo + " someThing: " + someThing);
		System.out.println("setFoo: it is going to be " + foo.getUserName() + " " + foo.getUserDescription() + " " + foo.getUserId());
		
	}
	
	
	
	
	

}

abstract class DoWhatYouWant {
	public abstract void doFoo(final String blah);
	
	public DoWhatYouWant() {
		System.out.println("It is a constructor in base class");
	}
}
