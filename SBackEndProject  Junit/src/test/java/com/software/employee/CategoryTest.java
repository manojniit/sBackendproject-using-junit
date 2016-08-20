package com.software.employee;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.software.employee.Dao.CategoryDao;
import com.software.employee.modal.Category;

public class CategoryTest {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.software");
		context.refresh();
		CategoryDao categoryDao=(CategoryDao) context.getBean("categoryDao");
		Category category=(Category)context.getBean("category");
		category.setId("c100097");
		category.setName("Electronics");
		category.setDescription("this is c100097 Discription");
		if (categoryDao.save(category)==true)
		{
			System.out.println("Category created successfully");
		}
		else 
		{
			System.out.println("Not able to create the category");
		}
	}

}
