package com.masith.mybatis.application;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.masith.mybatis.entity.Employee;

public class Insert {

	public static void main(String[] args) throws IOException, SQLException {

		Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		Employee employee = new Employee("java", "james gosling", 10000);
		
		SqlSession session = sqlSessionFactory.openSession();
		session.insert("Employee.insert", employee);
		System.out.println("record inserted successfully");
		session.commit();
		session.close();
	}
}
