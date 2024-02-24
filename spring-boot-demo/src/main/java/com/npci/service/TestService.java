package com.npci.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.npci.dao.DataSource;
import com.npci.dao.EmployeeDao;

public class TestService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//consider this is wriiten in service layer.
		// ref to the spring container which has all the obj
		
		//ClassPathXmlApplicationContext context =new ClassPathXmlApplicationContext("bean.xml");
		ApplicationContext context= new ClassPathXmlApplicationContext("beans.xml");
		//When you get the obj you must downcast to the right type
		//getBean is factory pattern method that return the obj from the container
		// below code is abstracting the obj that spring container is returning
		EmployeeDao  empDao = (EmployeeDao)context.getBean("b1");
		empDao.store();
		
		DataSource source = (DataSource)context.getBean("b3");
		System.out.println(source.getURL());
		System.out.println(source.getUserName());
		System.out.println(source.getPassword());
	}

}
