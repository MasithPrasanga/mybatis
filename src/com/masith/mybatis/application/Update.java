package com.masith.mybatis.application;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.masith.mybatis.entity.Employee;

public class Update {

	public static void main(String args[]) throws IOException {

		Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sqlSessionFactory.openSession();

		Employee employee = (Employee) session.selectOne("Employee.getById", 1);
		System.out.println("Current details of the student are");
		System.out.println(employee.toString());

		// Set new values to the mail and phone number of the student
		employee.setFirstName("rasith");
		employee.setLastName("priyanka");
		employee.setSalary(50000);

		// Update the student record
		session.update("Employee.update", employee);
		System.out.println("Record updated successfully");
		session.commit();
		session.close();

	}

}
