package com.met.iit.SpringBTest.services;

import java.sql.SQLException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.met.iit.SpringBTest.dao.EmployeeDAO;
import com.met.iit.SpringBTest.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDAO dao;
	
//	public void save(Employee emp) {
//		
//		dao.saveUsingJdbcTemplate(emp);
//		
//		
//	}

	public void save(Employee emp) {
		// TODO Auto-generated method stub
		dao.saveUsingJdbcTemplate(emp);
	}
	
	public Collection<Employee> getallEmp(){
		
		return dao.getAllEmployees();
		
	}
	
	public boolean call(int id, String pwd) throws SQLException {
		
		return dao.authenticate(id,pwd);
	}
	
	
	
}
