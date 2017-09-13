package com.masith.mybatis.application;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.masith.mybatis.entity.Employee;

public class ReadAll {
	
	 public static void main(String args[]) throws IOException{

	      Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
	      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);		
	      SqlSession session = sqlSessionFactory.openSession();
	      	
	      List<Employee> employeeList = session.selectList("Employee.getAll");
	          
	      for(Employee employee : employeeList ){
	    	 System.out.println("-----------------------------------------");
	    	 System.out.println(employee.getId());
	         System.out.println(employee.getFirstName());
	         System.out.println(employee.getLastName());
	         System.out.println(employee.getSalary());
	      }  
			
	      System.out.println("Records Read Successfully ");          
	      session.commit();   
	      session.close();			
	   }

}
