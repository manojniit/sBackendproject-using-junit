package com.software.employee;

import static org.junit.Assert.*;

import org.junit.Test;


	

	import org.junit.Before;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.context.annotation.AnnotationConfigApplicationContext;

	import com.software.employee.Dao.SupplierDao;
	import com.software.employee.modal.Supplier;

	public class TestCaseSupplier {

		@Autowired
		SupplierDao supplierDao;
		@Autowired
		Supplier supplier;
		AnnotationConfigApplicationContext context;
		@Before
		public void init()
		{
			context  = new AnnotationConfigApplicationContext();
			context.scan("com.software.employee");
			context.refresh();
			 supplierDao =(SupplierDao) context.getBean("supplierDao");
			 supplier=(Supplier) context.getBean("supplier");
		}
		@Test
		public void deleteSupplier()
		{
			supplier.setId("s_1");
			boolean flag = supplierDao.delete(supplier);
			assertEquals("deleteSupplierTest", flag,true);
		}
		@Test
		public void addSupplierTestCase()
		{
			supplier.setId("s_2");
			supplier.setName("PAVANIGANESH");
			
			supplier.setaddress("hyd");
			assertEquals("addSupplierTest",supplierDao.save(supplier),true);

		}
		@Test
		public void listSupplierTestCase()
		{
			
			assertEquals("supplierListTestCase ",supplierDao.list().size(),1);
		}
		@Test
	public void updateSupplierTestCase()
	{
		supplier.setId("s_2");
		supplier.setName("rahul");
		supplier.setaddress("india");
		assertEquals("updateSupplierTestCase",supplierDao.update(supplier),true);
	}
		@Test
		public void getSupplierTestCase()
		{
			supplier = supplierDao.get("s_2");
			assertEquals("getSupplierTestCase", supplier.getName(),"rahul");
		}
		
		}






