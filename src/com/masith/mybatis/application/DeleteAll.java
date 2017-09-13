package com.masith.mybatis.application;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class DeleteAll {
	
	public static void main(String args[]) throws IOException{
	      
	      Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
	      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);		
	      SqlSession session = sqlSessionFactory.openSession(); 
		  
	      //Delete operation
	      session.delete("Employee.deleteAll");     
	      session.commit();
	      session.close();      
	      System.out.println("Record deleted successfully");
				
	   }

}
