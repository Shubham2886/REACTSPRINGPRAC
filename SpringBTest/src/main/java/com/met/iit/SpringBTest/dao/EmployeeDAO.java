package com.met.iit.SpringBTest.dao;

import java.sql.SQLException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.met.iit.SpringBTest.model.Employee;

@Repository
public class EmployeeDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	
	public void saveUsingJdbcTemplate(Employee emp) {
		
		jdbcTemplate.update("insert into employee values (?, ?, ?, ?)", 
			new Object[] {emp.getId(), emp.getName(), emp.getEmailId(), emp.getDesignation()});
		
		
	}
	
	
public  Collection<Employee> getAllEmployees(){
		
		
		return jdbcTemplate.query("select * from employee", 
				
					new BeanPropertyRowMapper<Employee>(Employee.class)
					//new EmployeeMapper()
				
				);
		
		
	}

public boolean authenticate(int id, String pwd) throws SQLException {
	
//		var pstmt = DB.prepareStatement("select count(id) from admin where id=? and pwd=?");
//		pstmt.setString(1, id);
//		pstmt.setString(2, password);
//		var rs = pstmt.executeQuery();
//		rs.next();
//		int count = rs.getInt(1);
//		rs.close();
//		pstmt.close();
//		if(count == 1)
//			return true;
//		id = password = null;
//		return false;
	

	int a = this.jdbcTemplate.queryForObject(
			  "select count(id) from admin where id=? and pwd=?", Integer.class, new Object[] { id,pwd });
	
	
	if(a==0)
		return false;
	return true;
	
	}

//public int authenticate(){
//	
//	
//	return jdbcTemplate.query("select count(id) from admin where id=? and pwd=?", 
//			
//				new BeanPropertyRowMapper<Authenticate>(Authenticate.class)
//				
//			
//			);
//}
}
