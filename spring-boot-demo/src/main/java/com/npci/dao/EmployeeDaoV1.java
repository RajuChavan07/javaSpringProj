package com.npci.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

  // Spring createds obj of this class
//by default it's id is same as class name but first letter will be in lowercase
//i.e
@Repository
@Primary
public class EmployeeDaoV1 implements EmployeeDao{

	@Override
	public void store() {
		// TODO Auto-generated method stub
		System.out.println("*********store() inside V1**********");
		
	}

}
