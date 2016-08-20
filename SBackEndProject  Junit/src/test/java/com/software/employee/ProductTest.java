package com.software.employee;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.software.employee.Dao.ProductDao;
import com.software.employee.modal.Product;

public class ProductTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.software.employee");
		context.refresh();
		ProductDao productDao=(ProductDao) context.getBean("productDao");
		Product product=(Product) context.getBean("product");
		product.setId("p_1");
		product.setName("iphone");
		product.setPrice(50000);
		product.setDescription("this is iphone description");
		if(productDao.save(product)==true)
		{
			System.out.println("Product saved successfully");
		}
		else
		{
			System.out.println("Error while saving product");
		}
	}

}
