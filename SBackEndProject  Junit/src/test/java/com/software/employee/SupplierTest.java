package com.software.employee;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.software.employee.Dao.SupplierDao;
import com.software.employee.modal.Supplier;

public class SupplierTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.software");
		context.refresh();
		SupplierDao supplierDao=(SupplierDao) context.getBean("supplierDao");
		Supplier supplier=(Supplier) context.getBean("supplier");
		supplier.setId("s_1");
		supplier.setName("RAHUL");
		supplier.setaddress("hyd");
		if(supplierDao.save(supplier)==true)
		{
			System.out.println("Supplier saved successfully");
		}
		else
		{
			System.out.println("Error while saving supplier");
		}
			}

}
