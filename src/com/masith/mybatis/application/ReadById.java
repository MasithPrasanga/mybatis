package com.masith.mybatis.application;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.masith.mybatis.entity.Employee;

public class ReadById {

	public static void main(String args[]) throws IOException {

		Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sqlSessionFactory.openSession();

		Employee employee = (Employee) session.selectOne("Employee.getById", 1);

		System.out.println(employee.getId());
		System.out.println(employee.getFirstName());
		System.out.println(employee.getLastName());
		System.out.println(employee.getSalary());

		session.commit();
		session.close();

	}
}
