package com.met.iit.SpringBTest.controller;

import java.sql.SQLException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.met.iit.SpringBTest.model.Authenticate;
import com.met.iit.SpringBTest.model.Employee;
import com.met.iit.SpringBTest.services.EmployeeService;

@CrossOrigin
@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping
	@RequestMapping(value = "saveUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> saveEmp(@RequestBody Employee emp) {

		employeeService.save(emp);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);

	}

	@GetMapping
	@RequestMapping(value = "allEmps", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Employee>> getAllEmployees() {

		Collection<Employee> allEmployees = employeeService.getallEmp();
		return new ResponseEntity<Collection<Employee>>(allEmployees, HttpStatus.OK);
	}

	@PostMapping
	@RequestMapping(value = "login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> call(@RequestBody Authenticate auth) throws SQLException {
		String suc = "Success";
		String fail = "failed";

		boolean x = employeeService.call(auth.getId(), auth.getPwd());
		if (x != false)
			return new ResponseEntity<String>(suc, HttpStatus.OK);
		return new ResponseEntity<String>(fail
				, HttpStatus.OK);
	}

//	@PostMapping
//	@RequestMapping(value = "authenticate", consumes = MediaType.APPLICATION_JSON_VALUE,
//			produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Employee> authentication(@RequestBody  emp){
//		
//		employeeService.save(emp);
//		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
//		
//	}
}
