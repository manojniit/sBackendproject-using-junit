package com.software.employee;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.software.employee.Dao.UserDetailsDao;
import com.software.employee.modal.UserDetails;

public class UserDetailsTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.software");
		context.refresh();
		UserDetailsDao userDetailsDao=(UserDetailsDao) context.getBean("userDetailsDao");
		UserDetails userDetails=(UserDetails) context.getBean("userDetails");
		userDetails.setId("s100056");
		userDetails.setName("RAHUL");
		userDetails.setAddress("hyd");
		userDetails.setMail("manu.varikala@gmail.com");
		userDetails.setPassword("tejasri");
		userDetails.setContact("warangal");
		if(userDetailsDao.save(userDetails)==true)
		{
			System.out.println("UserDetails saved successfully");
		}
		else
		{
			System.out.println("Error while saving userDetails");
		}
			}

}
