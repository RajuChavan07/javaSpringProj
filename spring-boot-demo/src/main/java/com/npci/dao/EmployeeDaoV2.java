package com.npci.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository

public class EmployeeDaoV2 implements EmployeeDao{

	@Override
	public void store() {
		// TODO Auto-generated method stub
		System.out.println("*********store() inside V2**********");
		
	}

}
