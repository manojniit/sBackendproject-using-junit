package com.software.employee;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.software.employee.Dao.CategoryDao;
import com.software.employee.modal.Category;

public class TestCaseCategory {

	@Autowired
	CategoryDao categoryDao;
	@Autowired
	Category category;
	AnnotationConfigApplicationContext context;
	@Before
	public void init()
	{
		context  = new AnnotationConfigApplicationContext();
		context.scan("com.software.employee");
		context.refresh();
		 categoryDao =(CategoryDao) context.getBean("categoryDao");
		 category=(Category) context.getBean("category");
	}
	@Test
	public void deleteCategory()
	{
		category.setId("c10036");
		boolean flag = categoryDao.delete(category);
		assertEquals("deleteCategoryTest", flag,true);
	}
	@Test
	public void addCategoryTestCase()
	{
		category.setId("cg_1");
		category.setName("PAVANIGANESH");
		category.setDescription("this is description about cg_1");
		assertEquals("addCategoryTest",categoryDao.save(category),true);

	}
	@Test
	public void listCategoryTestCase()
	{
		
		assertEquals("categoryListTestCase ",categoryDao.list().size(),1);
	}
	@Test
public void updateCategoryTestCase()
{
	category.setId("cg_1");
	category.setName("manoj");
	category.setDescription("this is a my phone");
	assertEquals("updateCategoryTestCase",categoryDao.update(category),true);
}
	@Test
	public void getCategoryTestCase()
	{
		category = categoryDao.get("cg_1");
		assertEquals("getCategoryTestCase", category.getName(),"manoj");
	}
	
	}



