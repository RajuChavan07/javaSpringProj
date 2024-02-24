package com.npci.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.npci.dao.EmployeeDao;
// even in service layer also have interface with multiple service implementation
// for demo it wasnt created
@Service //
public class EmployeeService {
	
@Autowired	// no need for setter getter
//@Qualifier(value = "employeeDaoV1")
private EmployeeDao dao; // loosly coupled
//EmployeeDao v1 dao; tightly coupled code
//EmployeeDaoV2 dao; tightly coupled code
// generate setter getter
//Spring frmw  passes dao by internally calling setters with help of <property>

/*
 * public EmployeeDao getDao() { return dao; }
 */

//constructor
/*
 * public EmployeeService(EmployeeDao dao) { super(); this.dao = dao; }
 */


  public void setDao(EmployeeDao dao) { this.dao = dao; }
 

public void save() {
	System.out.println("********Service in save() is called******");
	dao.store();
}

}
