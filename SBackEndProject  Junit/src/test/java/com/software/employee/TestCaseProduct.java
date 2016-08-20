package com.software.employee;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.software.employee.Dao.ProductDao;
import com.software.employee.modal.Product;

public class TestCaseProduct {
	@Autowired
	ProductDao productDao;
	@Autowired
	Product product;
	AnnotationConfigApplicationContext context;
	@Before
	public void init()
	{
		context  = new AnnotationConfigApplicationContext();
		context.scan("com.software");
		context.refresh();
		 productDao =(ProductDao) context.getBean("productDao");
		 product=(Product) context.getBean("product");
	}
	@Test
	public void deleteProductTestCase()
	{
		product.setId("p_1");
		boolean flag = productDao.delete(product);
		
		assertEquals("deleteProductTestCase ",flag,true);
	}
	
	
	@Test
	public void addProductTestCase()
	{
		product.setId("p_2");
		product.setName("iphone");
		product.setDescription("this is iphone");
		product.setPrice(60000);
		assertEquals("addProductTestCase",productDao.save(product),true);
	}@Test
	public void listProductTestCase()
	{
		
		assertEquals("listProductTestCase", productDao.list().size(),1);
	}
	@Test
	public void updateProductTestCase()
	{
		product.setId("p_2");
		product.setPrice(80000);
		assertEquals("update Product Test Case ",productDao.update(product),true);
	}
	
	@Test
	public void getProductTestCase()
	{
		product = productDao.get("p_2");
		assertEquals("getProductTestCase",product.getName(),"iphone");
	}

}

