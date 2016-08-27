package com.shivs76.garage.fullservice;

import java.util.Arrays;
import org.junit.Test;
import java.util.List;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.shivs76.garage.fullservice.dao.EmployeeDAO;

import com.shivs76.garage.fullservice.dao.GenericDAO;
import com.shivs76.garage.fullservice.dao.ManagerDAO;
import com.shivs76.garage.fullservice.dao.TaskDAO;
import com.shivs76.garage.fullservice.dao.TimeSheetDAO;
import com.shivs76.garage.fullservice.domain.BaseEntity;
import com.shivs76.garage.fullservice.domain.Employee;
import com.shivs76.garage.fullservice.domain.Manager;
import com.shivs76.garage.fullservice.domain.Task;
import com.shivs76.garage.fullservice.domain.TimeSheet;
import com.shivs76.garage.fullservice.service.EmployeeService;
import com.shivs76.garage.fullservice.service.ManagerService;



/**
 * Unit test for simple App.
 */
public class AppTest 
{
	@Test
	public void doGenericWay() {
		org.springframework.context.support.FileSystemXmlApplicationContext fff = 
				new FileSystemXmlApplicationContext("C:\\projects\\garagews\\fullservice\\src\\main\\resources\\mvc-dispatcher-servlet.xml");
		// GenericDAO<Employee, String> tt1 = fff.getBean(GenericDAO.class);
		
		EmployeeDAO tt = fff.getBean(EmployeeDAO.class);
		System.out.println("it is "  + tt);
		
		Employee e = new Employee();
		e.setDepartment("Finance");
		e.setName("Shiv");
		
		Employee e2 = new Employee();
		e2.setDepartment("HR");
		e2.setName("Kumar");
		
		
		//tt.save(e2);
		
		Employee e3 = new Employee();
		((Employee) e3).setDepartment("Legal");
		((Employee) e3).setName("SK1");
		
		 tt.save(e3);
		
		Employee a1 = tt.findByName("SK1");
		System.out.println("it is " + a1);
		Manager m1 = new Manager();
		m1.setName("Shiv");
		ManagerDAO mm = fff.getBean(ManagerDAO.class);
		mm.save(m1);
		
		Manager m2 = new Manager();
		m2.setName("Arjun");
		//ManagerDAO mm = fff.getBean(ManagerDAO.class);
		mm.save(m2);
		
		Manager m3 = new Manager();
		m3.setName("Netra");
		//ManagerDAO mm = fff.getBean(ManagerDAO.class);
		mm.save(m3);
		
		
		
		 m2 = mm.findByName("Shiv");
		
		Task t1 = new Task();
		t1.setName("T1");
		t1.setDescription("A new task");
		t1.setCompleted(false);
		t1.setManager(m1);
		t1.setEmployeeList(Arrays.asList(e, e2));
		TaskDAO td = fff.getBean(TaskDAO.class);
		//td.save(t1);
		
		List<Task> t2 = td.findTaskByEmployee("Shivqqq");
		System.out.println("The task is " + t2);
		
		EmployeeService es = fff.getBean(EmployeeService.class);
		es.removeEmployee("SK1");
		
		TimeSheet ts1 = new TimeSheet();
		ts1.setName("TS1");
		ts1.setOwner(e);
		ts1.setTask(t1);
		ts1.setHours(4);
		TimeSheetDAO tsd = fff.getBean(TimeSheetDAO.class);
		// tsd.save(ts1);
		
		TimeSheet ts3 = new TimeSheet();
		ts3.setName("ts3");
		ts3.setOwner(e2);
		ts3.setTask(t1);
		ts3.setHours(40);
		// TimeSheetDAO tsd = fff.getBean(TimeSheetDAO.class);
		// tsd.save(ts3);
		
		
		
		List<TimeSheet> ts2 = tsd.findByEmployee("Kumar");
		System.out.println("---- " + ts2);
		
		ManagerService ms = fff.getBean(ManagerService.class);
		ms.removeManager("Netra");
		
		
		// org.springframework.data.domain.
		// ExampleMatcher em =  
		
		
		
		
		
		
		
		
		
		// mm.delete(m2);
		
		  
		//tt.save(e2);
		
		//Employee aaa = (Employee) tt.find("Shiv");
		//System.out.println("And it is " + aaa.getDepartment());
		//Employee eFind = tt.findByName("Kumar");
		//System.out.println( " it is " + eFind.getDepartment());
		
		/*Team t = new Team();
		t.setName("Aussies");;
		t.setDescription("All time good team");
		String[] players = {"Warner", "Burns", "Khawaja","Smith", "Voges","Marsh", "Nevill","Hazelwood","Lyon","Starc","Pattinson"};
		List<String> allP = Arrays.asList(players);
		t.setPlayers(allP);
		t.setCoach("Lehmann");
		
		tt.save(t);*/
		System.out.println("-------------------------------------------");	
		
		//List<Team> allT = tt.findBetweenRankings(2, 200,"^E");;
		
		
	}
}
