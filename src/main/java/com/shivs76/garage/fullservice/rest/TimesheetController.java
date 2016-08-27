package com.shivs76.garage.fullservice.rest;

import java.util.List;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shivs76.garage.fullservice.dao.ManagerDAO;
import com.shivs76.garage.fullservice.dao.TaskDAO;
import com.shivs76.garage.fullservice.dao.TimeSheetDAO;
import com.shivs76.garage.fullservice.domain.Employee;
import com.shivs76.garage.fullservice.domain.Manager;
import com.shivs76.garage.fullservice.domain.Task;
import com.shivs76.garage.fullservice.domain.TimeSheet;
import com.shivs76.garage.fullservice.resource.FooUser;
import com.shivs76.garage.fullservice.service.EmployeeService;
import com.shivs76.garage.fullservice.service.ManagerService;
import com.shivs76.garage.fullservice.service.TaskService;
import com.shivs76.garage.fullservice.service.TimeSheetService;

@RestController
@RequestMapping(path="/tsc")
public class TimesheetController {
	
	@Autowired
	private EmployeeService aES;
	
	@Autowired
	private TimeSheetService aTS;
	
	@Autowired
	private TaskService aTaS;
	
	@Autowired
	private ManagerService aMS;
	
	
	
	
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
			path="/task", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public void createTasks(@RequestBody Task aTask) {
		
		List<Employee> eAll = aTask.getEmployeeList();
		Manager manager = aTask.getManager();
		
		System.out.println("Check employee...");
		for(Employee e: eAll) {
			if(!aES.isEmployeePresent(e)) {
				aES.add(e);				
			}
		}
		System.out.println("Check MGR...");
		if (!aMS.isManagerPresent(manager)) {
			aMS.add(manager);
		}		
		System.out.println("Add tasks...");
		aTaS.add(aTask);
	}
	
	@RequestMapping(method = RequestMethod.GET,			
			path="/add", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public void addAll() {
		Employee e = new Employee();
		e.setDepartment("Finance");
		e.setName("Shiv");
		
		Employee e2 = new Employee();
		e2.setDepartment("HR");
		e2.setName("Kumar");
		
		aES.add(e);
		aES.add(e2);
		
		// add employee with no tasks!
		Employee e3 = new Employee();
		e3.setDepartment("Finance");
		e3.setName("Shiv11");
		
		Employee e21 = new Employee();
		e21.setDepartment("HR");
		e21.setName("Kumar11");
		
		aES.add(e3);aES.add(e21);
		
		Manager m1 = new Manager();
		m1.setName("Shiv");		
		Manager m2 = new Manager();
		m2.setName("Arjun");
		
		Manager m3 = new Manager();
		m3.setName("Netra");
		
		aMS.add(m1);aMS.add(m2);aMS.add(m3);
		
		Task t1 = new Task();
		t1.setName("T1");
		t1.setDescription("A new task");
		t1.setCompleted(false);
		t1.setManager(m1);
		t1.setEmployeeList(Arrays.asList(e, e2));		
		aTaS.add(t1);
		
		Task t11 = new Task();
		t11.setName("T2");
		t11.setDescription("A new task again");
		t11.setCompleted(false);
		t11.setManager(m1);
		t11.setEmployeeList(Arrays.asList(e, e2));		
		aTaS.add(t11);
		
		
		TimeSheet ts1 = new TimeSheet();
		ts1.setName("TS1");
		ts1.setOwner(e);
		ts1.setTask(t1);
		ts1.setHours(4);
		aTS.add(ts1);
		
		TimeSheet ts3 = new TimeSheet();
		ts3.setName("ts3");
		ts3.setOwner(e2);
		ts3.setTask(t1);
		ts3.setHours(40);
		aTS.add(ts3);
		
		
		
		
		
		
		
		
		
	}

}
