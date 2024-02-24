package com.npci;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.npci.dao.EmployeeDao;
import com.npci.service.EmployeeService;

@SpringBootApplication //automatically configure application e.g componant scanning
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootDemoApplication.class, args);
		//initialy getting a dao obj but later we will 
		/*
		 * EmployeeDao dao = (EmployeeDao)context.getBean("employeeDaoV1"); dao.store();
		 * 
		 * EmployeeDao dao1 = (EmployeeDao)context.getBean("employeeDaoV2");
		 * dao1.store();
		 */
		// Write @Repository in v2 and get that obj here to call store
		
		EmployeeService service = (EmployeeService) context.getBean("employeeService");
		service.save();
	}

}
